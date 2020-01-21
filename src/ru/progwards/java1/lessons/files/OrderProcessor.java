package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderProcessor {

    private String startPath;
    private int failedFileNumber;
    private Map<String, List<Order>> ordersByShops; // key: shopId, value: ordersList

    public OrderProcessor(String startPath) {
        this.startPath = startPath;
        failedFileNumber = 0;
    }

    //    загружает заказы за указанный диапазон дат, с start до finish, обе даты включительно.
//    Если start == null, значит нет ограничения по дате слева, если finish == null,
//    значит нет ограничения по дате справа, если shopId == null - грузим для всех магазинов
//    При наличии хотя бы одной ошибке в формате файла, файл полностью игнорируется, т.е. Не поступает в обработку.
//    Метод возвращает количество файлов с ошибками. При этом, если в классе содержалась информация, ее надо удалить
    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {

        if (start == null)
            start = LocalDate.of(1970, 1, 1);
        if (finish == null)
            finish = LocalDate.now();
        if (shopId == null)
            shopId = "";
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/" + shopId + "*.txt");
        try {
            Files.walkFileTree(Paths.get(startPath), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileName = file.getFileName().toString();
                    String[] idsArr = fileName.split("-");
                    Order order = new Order();
                    order.shopId = idsArr[0];
                    order.orderId = idsArr[1];
                    order.customerId = idsArr[2];
                    order.datetime = LocalDateTime.ofInstant(Files.getLastModifiedTime(file).toInstant(), ZoneId.systemDefault());
                    order.items = new ArrayList<>();
                    order.sum = 0;
                    List<String> goods = Files.readAllLines(file);
                    for (String goodStr : goods
                         ) {
                        String[] strArr = goodStr.trim().split("\\s*,\\s*");

                        if (strArr.length != 3) {
                            failedFileNumber++;
                            return FileVisitResult.CONTINUE;
                        }

                        int goodsCount = Integer.parseInt(strArr[1]);
                        double oneGoodPrice = Double.parseDouble(strArr[2]);

                        OrderItem orderItem = new OrderItem();
                        orderItem.count = goodsCount;
                        orderItem.price = oneGoodPrice;
                        orderItem.goodsName = strArr[0];

                        order.items.add(orderItem);
                        order.sum += (goodsCount * oneGoodPrice);

//                        for (char ch : strArr[1].toCharArray()
//                             ) {
//                            if (!Character.isDigit(ch))
//                                return FileVisitResult.CONTINUE;
//                        }
//
//                        int decimalSeparatorCounter = 0;
//                        for (char ch : strArr[2].toCharArray()
//                        ) {
//                            if (!Character.isDigit(ch) || !String.valueOf(ch).equals("."))
//                                return FileVisitResult.CONTINUE;
//
//                        }
                    }

                    ordersByShops.putIfAbsent(order.shopId, new ArrayList<>());
                    ordersByShops.get(order.shopId).add(order);

                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            //
        }
            return failedFileNumber;
        }
    }

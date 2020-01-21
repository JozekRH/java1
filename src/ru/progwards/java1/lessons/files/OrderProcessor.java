package ru.progwards.java1.lessons.files;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

public class OrderProcessor {

    private String startPath;
    private Map<String, List<Order>> ordersByShops;

    public OrderProcessor(String startPath) {
        this.startPath = startPath;
    }

//    загружает заказы за указанный диапазон дат, с start до finish, обе даты включительно.
//    Если start == null, значит нет ограничения по дате слева, если finish == null,
//    значит нет ограничения по дате справа, если shopId == null - грузим для всех магазинов
//    При наличии хотя бы одной ошибке в формате файла, файл полностью игнорируется, т.е. Не поступает в обработку.
//    Метод возвращает количество файлов с ошибками. При этом, если в классе содержалась информация, ее надо удалить
    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {
        if (start == null)
            start = LocalDate.of(1970,1,1);
        if (finish == null)
            finish = LocalDate.now();
        //
        return 0;
    }
}

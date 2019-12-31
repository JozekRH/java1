package ru.progwards.java1.lessons.maps;

import org.glassfish.grizzly.utils.Pair;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SalesInfo {

    private static String orders;

    public static int loadOrders(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        int linesNumber = 0;
        try(FileReader fileReader = new FileReader(fileName);
            Scanner sc = new Scanner(fileReader)) {
            while (sc.hasNextLine()) {
                String str = sc.nextLine().trim();
                String[] fieldsInLine = str.split("\\s*,\\s*");
                if(fieldsInLine.length != 4 || !fieldsInLine[2].matches("\\d+")
                        || !fieldsInLine[3].matches("\\d+(.\\d+)?")) {
                    continue;
                }
                stringBuilder.append(str).append("\n");
                linesNumber++;
            }
            orders = stringBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return linesNumber;
    }

    public static Map<String, Double> getGoods() {
        Map<String, Double> map = new TreeMap<>();
        try(Scanner sc = new Scanner(orders)) {
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] fieldsInLine = str.split("\\s*,\\s*");
                String productName = fieldsInLine[1];
                Double cost = Double.valueOf(fieldsInLine[3]);
                if(map.containsKey(productName)) {
                    map.put(productName, map.get(productName)+cost);
                } else {
                    map.put(productName, cost);
                }
            }

        }

        return  map;
    }

    public static Map<String, Pair<Double, Integer>> getCustomers() {
        Map<String, Pair<Double, Integer>> map = new TreeMap<>();
        try(Scanner sc = new Scanner(orders)) {
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] fieldsInLine = str.split("\\s*,\\s*");
                String customerName = fieldsInLine[0];
                Integer goodsNumber = Integer.valueOf(fieldsInLine[2]);
                Double cost = Double.valueOf(fieldsInLine[3]);
                if(map.containsKey(customerName)) {
                    Pair<Double, Integer> customerData = map.get(customerName);
                    customerData.setFirst(customerData.getFirst() + cost);
                    customerData.setSecond(customerData.getSecond() + goodsNumber);
                    map.put(customerName, customerData);
                } else {
                    map.put(customerName, new Pair<>(cost, goodsNumber));
                }
            }

        }
        return  map;
    }

    public static void main(String[] args) {
        String fileName = "D:\\sales.csv";
        System.out.println(orders);
        System.out.println(loadOrders(fileName));
        System.out.println(orders);
        System.out.println(getGoods());
        System.out.println(getCustomers());
    }
}

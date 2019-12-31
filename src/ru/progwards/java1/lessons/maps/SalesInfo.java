package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SalesInfo {

    private static String orders = "";

    public static int loadOrders(String fileName) {
        try(FileReader fileReader = new FileReader(fileName);
            Scanner sc = new Scanner(fileReader)) {
            StringBuilder sb = new StringBuilder();
            int linesNumber = 0;
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] fieldsInLine = str.split("\\s*,\\s*");
                //System.out.println(Arrays.toString(fieldsInLine));
                if(fieldsInLine.length != 4 || !fieldsInLine[2].matches("\\d+")
                        || !fieldsInLine[3].matches("\\d+(.\\d+)?")) {
                    continue;
                }
                //System.out.println(str);
                sb.append(fieldsInLine[0]);
                linesNumber++;
            }
            orders = sc.toString();
            return linesNumber;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        String fileName = "C:\\Users\\artyom\\Desktop\\Новая папка (2)\\studyJava\\progwards\\Java Базовый уровень\\15 Словари (map)\\sales1.txt";
        System.out.println(orders);
        System.out.println(loadOrders(fileName));
        System.out.println(orders);
    }
}

package ru.progwards.java1.lessons.maps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UsageFrequency {

    private static String cache;

    public static void processFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName);
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
            cache = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Character, Integer> getLetters() {
        Map<Character, Integer> map = new TreeMap<>();
        try (Scanner sc = new Scanner(cache).useDelimiter("")) {
            while (sc.hasNext()) {
                char ch = sc.next().charAt(0);
                if (Character.isLetter(ch) || Character.isDigit(ch)) {
                    if (map.containsKey(ch)) {
                        map.put(ch, map.get(ch) + 1);
                    } else {
                        map.put(ch, 1);
                    }
                }
            }
            return map;
        }
    }

    public static Map<String, Integer> getWords() {
        Map<String, Integer> map = new TreeMap<>();
        try (Scanner sc = new Scanner(cache).useDelimiter("\\W+")) {
            while (sc.hasNext()) {
                String word = sc.next();
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String fileNameTest = "D:\\wiki.test.tokens";
        String fileName = "D:\\wiki.train.tokens";
        processFile(fileName);
        System.out.println(getLetters());
        System.out.println(getWords());

    }
}

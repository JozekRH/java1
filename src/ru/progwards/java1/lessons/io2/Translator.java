package ru.progwards.java1.lessons.io2;

import java.util.Scanner;

public class Translator {
    private final String[] inLang;
    private final String[] outLang;

    public Translator(String[] inLang, String[] outLang) {
        this.inLang = inLang;
        this.outLang = outLang;
    }

    public String translate(String sentence) {
        try(Scanner scanner = new Scanner(sentence)) {
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                String word = scanner.next();
                for (int i = 0; i < inLang.length; i++) {
                    if (word.toLowerCase().contains(inLang[i])) {
                        if (word.substring(0, 1).equals(inLang[i].substring(0, 1).toUpperCase())) {
                            sb.append(outLang[i].substring(0, 1).toUpperCase())
                                    .append(outLang[i].substring(1, outLang[i].length()));
                        } else {
                            sb.append(outLang[i]);
                        }
                        break;
                    }
                }
                int indexOfPunctuation = -1;
                for (int i = word.length() - 1; i >= 0; i--) {
                    if (Character.isAlphabetic(word.charAt(i)) || Character.isDigit(word.charAt(i))) {
                        break;
                    }
                    indexOfPunctuation = i;
                }
                if (indexOfPunctuation != -1) {
                    sb.append(word.substring(indexOfPunctuation));
                }

                if (scanner.hasNext()) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String[] inLang = {"hello", "world"};
        String[] outLang = {"привет", "мир"};
        System.out.println(new Translator(inLang, outLang).translate("Hello.!.,? World!!!!"));
    }
}

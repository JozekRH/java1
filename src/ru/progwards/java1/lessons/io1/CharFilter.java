package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter) throws Exception {
        FileReader reader = new FileReader(inFileName);
        FileWriter writer = new FileWriter(outFileName, true);
        try {
            char[] charArrFilter = filter.toCharArray();
            int symbol;
            outer:
            while (true) {
                symbol = reader.read();
                if (symbol == -1)
                    break;
                for (char c : charArrFilter) {
                    if (c == (char) symbol) {
                        continue outer;
                    }
                }
                writer.write((char) symbol);
            }
        } finally {
            reader.close();
            writer.close();
        }
    }
}

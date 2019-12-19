package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {
    public static int calcEmpty(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);

            try {
                int emptyStrNum = 0;
                Scanner scanner = new Scanner(fileReader);
                while (scanner.hasNextLine()) {
                    if(scanner.nextLine().isEmpty())
                        emptyStrNum++;
                }
                return emptyStrNum;

            } finally {
                fileReader.close();
            }
        } catch (Exception e) {
            return -1;
        }
    }
}

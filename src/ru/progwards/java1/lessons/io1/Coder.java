package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Coder {
    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        try {
            FileWriter logFile = new FileWriter(logName, true);
            try {
                FileReader reader = new FileReader(inFileName);
                FileWriter writer = new FileWriter(outFileName, true);

                try {
                    int symbol = reader.read();
                    while (symbol != -1) {
                        writer.write(code[symbol]);
                        symbol = reader.read();
                    }

                } finally {
                    reader.close();
                    writer.close();
                }
            } catch (Exception e) {
                logFile.write(e.getMessage() + "\n");
            } finally {
                logFile.close();
            }
        } catch (IOException e) {
            //
        }
    }
}

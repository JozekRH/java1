import ru.progwards.java1.lessons.bigints.*;
import ru.progwards.java1.lessons.interfaces2.ArraySort;
import ru.progwards.java1.lessons.interfaces2.DoubleNumber;
import ru.progwards.java1.lessons.interfaces2.IntNumber;
import ru.progwards.java1.lessons.io1.Coder;
import ru.progwards.java1.lessons.io1.LineCount;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        try {
//            FileReader reader = new FileReader("D:\\file.txt");
//
//            try {
//
//                //Scanner scanner = new Scanner(fileReader);
//                Scanner inScanner = new Scanner(reader);
//                int symbol = reader.read();
//                while (symbol != -1) {
//                    //writer.write(code[symbol]);
//                    System.out.println((char) symbol  + "---" + symbol);
//                    symbol = reader.read();
//                }
//                return ;
//
//            } finally {
//                reader.close();
//            }
//        } catch (Exception e) {
//            //return -1;
//        }
        System.out.println(LineCount.calcEmpty("D:\\file.txt"));

    }
}

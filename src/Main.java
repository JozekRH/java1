import ru.progwards.java1.lessons.bigints.*;
import ru.progwards.java1.lessons.interfaces2.ArraySort;
import ru.progwards.java1.lessons.interfaces2.DoubleNumber;
import ru.progwards.java1.lessons.interfaces2.IntNumber;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IntNumber[] intArr = new IntNumber[10];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = new IntNumber((int)(Math.random() * 10));
        }
        System.out.println(Arrays.toString(intArr));
        ArraySort.sort(intArr);
        System.out.println(Arrays.toString(intArr));
        System.out.println("---------------------");
        DoubleNumber[] doubleArr = new DoubleNumber[10];
        for (int i = 0; i < doubleArr.length; i++) {
            doubleArr[i] = new DoubleNumber((Math.random() * 10));
        }
        System.out.println(Arrays.toString(doubleArr));
        ArraySort.sort(doubleArr);
        System.out.println(Arrays.toString(doubleArr));
    }
}

import ru.progwards.java1.lessons.arrays.ArraySort;
import ru.progwards.java1.lessons.bitsworld.Binary;
import ru.progwards.java1.lessons.bitsworld.CheckBit;
import ru.progwards.java1.lessons.bitsworld.SumBits;
import ru.progwards.java1.lessons.compare_if_cycles.CyclesGoldenFibo;
import ru.progwards.java1.lessons.compare_if_cycles.TriangleSimpleInfo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        for(int i = -128; i < 128; i++) {
            System.out.println(new Binary((byte)i).toString());
        }

    }
}

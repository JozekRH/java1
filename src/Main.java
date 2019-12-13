import ru.progwards.java1.lessons.arrays.ArraySort;
import ru.progwards.java1.lessons.compare_if_cycles.CyclesGoldenFibo;
import ru.progwards.java1.lessons.compare_if_cycles.TriangleSimpleInfo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {-58,-57,29,62,-77,-94,-96,55,65,78,-24,63};
        ArraySort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}

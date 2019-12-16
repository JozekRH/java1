

import ru.progwards.java1.lessons.abstractnum.Ball;
import ru.progwards.java1.lessons.abstractnum.DoubleNumber;
import ru.progwards.java1.lessons.abstractnum.IntNumber;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Double d1 = Double.valueOf("3.14");
//        System.out.println(d1.intValue());
//        System.out.println(Double.parseDouble("4"));

        IntNumber intSegm = new IntNumber(1);
        DoubleNumber doubleSegm = new DoubleNumber(1.0);
        Ball ball1 = new Ball(intSegm);
        Ball ball2 = new Ball(doubleSegm);
        System.out.println(((IntNumber)ball1.volume()).number);
        System.out.println(((DoubleNumber)ball2.volume()).number);


    }
}

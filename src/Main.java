

import ru.progwards.java1.lessons.abstractnum.Ball;
import ru.progwards.java1.lessons.abstractnum.DoubleNumber;
import ru.progwards.java1.lessons.abstractnum.IntNumber;
import ru.progwards.java1.lessons.bigints.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AbsInteger num1 = new ByteInteger((byte)-25);
        AbsInteger num2 = new ShortInteger((short)1424);
        AbsInteger res = AbsInteger.add(num1, num2);
        System.out.println(res);
        System.out.println(res.getClass().getName());
    }
}

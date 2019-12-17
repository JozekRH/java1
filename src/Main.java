

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
        BigInteger bi1 = new BigInteger("17179869184");
        ArrayInteger ai1 = new ArrayInteger(4);
        ai1.fromInt(bi1);
        System.out.println(ai1.toInt());
    }
}



import ru.progwards.java1.lessons.abstractnum.Ball;
import ru.progwards.java1.lessons.abstractnum.DoubleNumber;
import ru.progwards.java1.lessons.abstractnum.IntNumber;
import ru.progwards.java1.lessons.bigints.ArrayInteger;
import ru.progwards.java1.lessons.bigints.BigAlgebra;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayInteger arrayInteger = new ArrayInteger(12);
        arrayInteger.fromInt(new BigInteger("282429536481"));
        System.out.println(arrayInteger.toInt());
        System.out.println("-------------------------------");
        ArrayInteger ai1 = new ArrayInteger(8);
        ai1.fromInt(new BigInteger("18493788"));
        ArrayInteger ai2 = new ArrayInteger(6);
        ai2.fromInt(new BigInteger("188637"));
        ai1.add(ai2);
        System.out.println(ai1.toInt() + " == 18682425");
    }
}

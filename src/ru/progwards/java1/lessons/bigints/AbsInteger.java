package ru.progwards.java1.lessons.bigints;

public class AbsInteger {

    public static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        int sum = num1.getNumber().intValue() + num2.getNumber().intValue();

        if(sum >= Byte.MIN_VALUE && sum <= Byte.MAX_VALUE)
            return new ByteInteger((byte)sum);
        if(sum >= Short.MIN_VALUE && sum <= Short.MAX_VALUE)
            return new ShortInteger((short) sum);
        return new IntInteger(sum);
    }

    Number getNumber() {
        return null;
    }
}

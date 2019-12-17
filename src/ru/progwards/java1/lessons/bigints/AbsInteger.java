package ru.progwards.java1.lessons.bigints;

public class AbsInteger {
    public static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        AbsInteger res = new AbsInteger();
        res.setNumber(num1.getNumber().intValue() + num2.getNumber().intValue());
        return res;
    }

    public Number getNumber() {
        return null;
    }

    public void setNumber(int number) {
    }
}

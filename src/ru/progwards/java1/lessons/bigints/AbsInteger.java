package ru.progwards.java1.lessons.bigints;

public class AbsInteger {

    public static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        int sum = num1.getNumber().intValue() + num2.getNumber().intValue();
        return num1.createNewInteger(sum);
    }

    public AbsInteger createNewInteger(int num) {
        return null;
    }

    public Number getNumber() {
        return null;
    }
}

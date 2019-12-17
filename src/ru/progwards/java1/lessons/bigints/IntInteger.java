package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger {
    public int number;

    public IntInteger(int number) {
        this.number = number;
    }

    @Override
    public IntInteger createNewInteger(int num) {
        return new IntInteger(num);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public Integer getNumber() {
        return number;
    }
}
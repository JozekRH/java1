package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger {
    public int number;

    public IntInteger(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public Integer getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }
}
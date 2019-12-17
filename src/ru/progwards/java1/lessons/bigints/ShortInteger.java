package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger {
    private short number;

    public ShortInteger(short number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Short.toString(number);
    }

    @Override
    Short getNumber() {
        return number;
    }
}

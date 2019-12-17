package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger {
    public short number;

    public ShortInteger(short number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Short.toString(number);
    }

    @Override
    public Short getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = (short)number;
    }
}

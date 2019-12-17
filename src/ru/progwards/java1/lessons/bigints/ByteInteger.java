package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {
    private byte number;

    public ByteInteger(byte number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Byte.toString(number);
    }

    @Override
    Byte getNumber() {
        return number;
    }
}

package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {
    public byte number;

    public ByteInteger(byte number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Byte.toString(number);
    }

    @Override
    public Byte getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = (byte)number;
    }
}

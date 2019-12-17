package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {
    public byte number;

    public ByteInteger(byte number) {
        this.number = number;
    }

    @Override
    public ByteInteger createNewInteger(int num) {
        return new ByteInteger((byte)num);
    }

    @Override
    public String toString() {
        return Byte.toString(number);
    }

    @Override
    public Byte getNumber() {
        return number;
    }
}

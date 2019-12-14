package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {
    public static int checkBit(byte value, int bitNumber) {
        for(int i = 0; i < bitNumber; i++) {
            value = (byte)(value >> 1);
        }
        return value & 1;
    }
}

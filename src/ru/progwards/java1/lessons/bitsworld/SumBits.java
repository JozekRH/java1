package ru.progwards.java1.lessons.bitsworld;

public class SumBits {
    public static int sumBits(byte value) {
        int res = 0;
        for(int i = 0; i < 8; i++) {
            res += (value & 1);
            value = (byte)(value >>> 1);
        }
        return res;
    }
}

package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    private byte num;

    public Binary(byte num) {
        this.num = num;
    }

    @Override
    public String toString() {
        String res = "";
        for(int i = 0; i < 8; i++) {
            res = (num & 1) + res;
            num = (byte)(num >>> 1);
        }
        return res;
    }
}

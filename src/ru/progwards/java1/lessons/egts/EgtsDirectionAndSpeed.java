package ru.progwards.java1.lessons.egts;

public class EgtsDirectionAndSpeed {

    public static int getSpeed(short speedAndDir) {

        return (int)speedAndDir & 0b00000000_00000000_01111111_11111111;
    }

    public static int getDirection(byte dirLow, short speedAndDir) {
        return ((int)dirLow & 0b00000000_00000000_00000000_11111111)
                + (((int)speedAndDir & 0b00000000_00000000_10000000_00000000) >>> 7);
    }
}

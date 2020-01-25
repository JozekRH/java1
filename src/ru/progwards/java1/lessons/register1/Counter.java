package ru.progwards.java1.lessons.register1;

public class Counter {

    public static void inc(ByteRegister value) {
        Bit[] byteValue = value.byteValue;
        for (int i = 0; i < byteValue.length; i++) {
            Bit bit = byteValue[i];
            if (!bit.value) {
                bit.value = true;
                return;
            } else {
                bit.value = false;
            }
        }
    }

    public static void dec(ByteRegister value) {
        Bit[] byteValue = value.byteValue;
        for (int i = 0; i < byteValue.length; i++) {
            Bit bit = byteValue[i];
            if (bit.value) {
                bit.value = false;
                return;
            } else {
                bit.value = true;
            }
        }
    }
}

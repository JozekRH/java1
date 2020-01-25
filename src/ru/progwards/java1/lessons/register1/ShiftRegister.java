package ru.progwards.java1.lessons.register1;

public class ShiftRegister {

    public static void left(ByteRegister value) {
        Bit[] byteValue = value.byteValue;
        for (int i = 1; i < byteValue.length; i++) {
            Bit bitCurrent = byteValue[i];
            Bit bitPrev = byteValue[i-1];
            bitCurrent.value = bitPrev.value;
        }
        byteValue[0].value = false;
    }

    public static void right(ByteRegister value) {
        Bit[] byteValue = value.byteValue;
        for (int i = byteValue.length-2; i >= 0; i--) {
            Bit bitCurrent = byteValue[i];
            Bit bitPrev = byteValue[i+1];
            bitCurrent.value = bitPrev.value;
        }
        byteValue[byteValue.length-1].value = false;
    }
}

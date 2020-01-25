package ru.progwards.java1.lessons.register1;

public class Summator {
    public static boolean add(ByteRegister value1, ByteRegister value2) {
        Bit[] byteValue1 = value1.byteValue;
        Bit[] byteValue2 = value2.byteValue;
        boolean noOverflow = true;

        outerLoop:
        for (int i = 0; i < byteValue2.length; i++) {
            if (!byteValue2[i].value) {
                continue;
            }

            for (int j = i; j < byteValue1.length; j++) {
                Bit bit1 = byteValue1[j];
                if (!bit1.value) {
                    bit1.value = true;
                    continue outerLoop;
                } else {
                    bit1.value = false;
                }
            }
            noOverflow = false;
        }
        return noOverflow;
    }
}

package ru.progwards.java1.lessons.register2;

public class Summator {

    private Register toTwosComplement(Register value) {
        Bit[] registerValue = value.registerValue;
        Register newReg = new Register(registerValue.length);
        Bit[] newRegValue = newReg.registerValue;
        for (int i = 0; i < registerValue.length; i++) {
            newRegValue[i].value = !registerValue[i].value;
        }
        Counter.inc(newReg);
        return newReg;
    }
    
    public static boolean add(Register value1, Register value2) {
        Bit[] registerValue1 = value1.registerValue;
        Bit[] registerValue2 = value2.registerValue;
        boolean noOverflow = true;

        outerLoop:
        for (int i = 0; i < registerValue2.length; i++) {
            if (!registerValue2[i].value) {
                continue;
            }

            for (int j = i; j < registerValue1.length; j++) {
                Bit bit1 = registerValue1[j];
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

    public static void sub(Register value1, Register value2) {
        add(value1, new Summator().toTwosComplement(value2));
    }
}

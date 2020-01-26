package ru.progwards.java1.lessons.register2;

public class Counter {
    
    public static void inc(Register value) {
        Bit[] registerValue = value.registerValue;
        for (int i = 0; i < registerValue.length; i++) {
            Bit bit = registerValue[i];
            if (!bit.value) {
                bit.value = true;
                return;
            } else {
                bit.value = false;
            }
        }
    }

    public static void dec(Register value) {
        Bit[] registerValue = value.registerValue;
        for (int i = 0; i < registerValue.length; i++) {
            Bit bit = registerValue[i];
            if (bit.value) {
                bit.value = false;
                return;
            } else {
                bit.value = true;
            }
        }
    }

    public static void main(String[] args) {
        IntRegister intReg = new IntRegister(-2147483640);
        System.out.println(intReg.toString());
        System.out.println(intReg.toDecString());
        System.out.println("intReg = -2147483640, then decremented 15 times");
        for (int i = 0; i < 15; i++) {
            dec(intReg);
            System.out.println(intReg.toString());
            System.out.println(intReg.toDecString());
        }
    }
}

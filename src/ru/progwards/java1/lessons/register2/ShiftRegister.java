package ru.progwards.java1.lessons.register2;

public class ShiftRegister {
    public static void left(Register value) {
        Bit[] registerValue = value.registerValue;
        for (int i = registerValue.length-1; i > 0; i--) {
            Bit bitCurrent = registerValue[i];
            Bit bitPrev = registerValue[i-1];
            bitCurrent.value = bitPrev.value;
        }
        registerValue[0].value = false;
    }

    public static void right(Register value) {
        Bit[] registerValue = value.registerValue;
        for (int i = 0; i < registerValue.length-1; i++) {
            Bit bitCurrent = registerValue[i];
            Bit bitNext = registerValue[i+1];
            bitCurrent.value = bitNext.value;
        }
        registerValue[registerValue.length-1].value = false;
    }

    public static void main(String[] args) {
        IntRegister intReg = new IntRegister(1);
        System.out.println(intReg.toString());
        System.out.println(intReg.toDecString());
        System.out.println("intReg = 1, then shifted left 15 times");
        for (int i = 0; i < 15; i++) {
            left(intReg);
            System.out.println(intReg.toString());
            System.out.println(intReg.toDecString());
        }
    }
}

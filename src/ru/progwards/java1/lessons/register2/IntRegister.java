package ru.progwards.java1.lessons.register2;

public class IntRegister extends Register {

    public IntRegister() { // инициализация нулями
        super(32);
    }
    
    public IntRegister(int value) {
        this();
        for (int i = 0; i < registerValue.length; i++) {
            registerValue[i].value = (value & 1) == 1;
            value >>>= 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-10));
        IntRegister intReg = new IntRegister(-10);
        System.out.println(intReg.toString());
        System.out.println(intReg.toDecString());
    }
}

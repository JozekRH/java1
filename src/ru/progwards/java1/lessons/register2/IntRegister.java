package ru.progwards.java1.lessons.register2;

public class IntRegister extends Register {

    public IntRegister() { // инициализация нулями
        super();
    }
    
    public IntRegister(int value) {
        super(value);
    }

    public static void main(String[] args) {
        IntRegister intReg = new IntRegister(96);
        ByteRegister byteReg = new ByteRegister((byte)169);
        System.out.println(Summator.add(intReg, byteReg));
        System.out.println(intReg.toDecString());
    }
}

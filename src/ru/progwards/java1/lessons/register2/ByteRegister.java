package ru.progwards.java1.lessons.register2;

public class ByteRegister extends Register {

    public ByteRegister() { // инициализация нулями
        super(8);
    }

    public ByteRegister(byte value) {
        this();
        for (int i = 0; i < registerValue.length; i++) {
            registerValue[i].value = (value & 1) == 1;
            value >>>= 1;
        }
    }
}

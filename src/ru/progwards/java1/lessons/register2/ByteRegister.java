package ru.progwards.java1.lessons.register2;

public class ByteRegister extends Register {

    public ByteRegister() { // инициализация нулями
        super();
    }

    public ByteRegister(byte value) {
       super((int)value);
    }
}

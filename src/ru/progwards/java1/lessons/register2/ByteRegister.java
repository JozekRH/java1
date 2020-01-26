package ru.progwards.java1.lessons.register2;

public class ByteRegister extends Register {

    public ByteRegister() { // инициализация нулями
        super(8);
    }

    // обратить внимание на то, что в Java byte знаковый, а у нас нет.
    // При сохранении просто копируем побитно, просто по другому интерпретируем значение.
    public ByteRegister(byte value) {
        this();
        int unsignedValue = (int)value & 0xFF;
        for (int i = 0; i < registerValue.length; i++) {
            registerValue[i] = new Bit ((unsignedValue & 1) == 1);
            unsignedValue >>>= 1;
        }
    }
}

package ru.progwards.java1.lessons.register1;

public class ByteRegister {

    public Bit[] byteValue;

    public ByteRegister() { // инициализация нулями
        byteValue = new Bit[8];
        for (int i = 0; i < byteValue.length; i++) {
            byteValue[i] = new Bit(false);
        }
    }

    // обратить внимание на то, что в Java byte знаковый, а у нас нет.
    // При сохранении просто копируем побитно, просто по другому интерпретируем значение.
    public ByteRegister(byte value) {
        byteValue = new Bit[8];
        int unsignedValue = (int)value & 0xFF;
        for (int i = 0; i < byteValue.length; i++) {
            byteValue[i] = new Bit ((unsignedValue & 1) == 1);
            unsignedValue >>>= 1;
        }
    }

    public String toString() { // вывод в двоичном виде
        int value = 0;
        int bitValue = 0;
        for (int i = 0; i < byteValue.length; i++) {
            bitValue = byteValue[i].value ? 1 : 0;
            value += bitValue;
            value <<= 1;
        }
        return Integer.toBinaryString(value);
    }

    public String toDecString() {
        int value = 0;
        int bitValue = 0;
        for (int i = 0; i < byteValue.length; i++) {
            bitValue = byteValue[i].value ? 1 : 0;
            value += bitValue;
            value <<= 1;
        }
        return Integer.toString(value);
    }
}

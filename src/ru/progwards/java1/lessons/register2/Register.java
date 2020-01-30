package ru.progwards.java1.lessons.register2;

public class Register {

    public Bit[] registerValue;

    public Register() { // инициализация нулями
        int length = 32;
        registerValue = new Bit[length];
        for (int i = 0; i < length; i++) {
            registerValue[i] = new Bit();
        }
    }

    public Register(int value) {
        this();
        for (int i = 0; i < registerValue.length; i++) {
            registerValue[i].value = (value & 1) == 1;
            value >>>= 1;
        }
    }

    public String toString() { // вывод в двоичном виде
        int bitValue = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = registerValue.length-1; i >= 0; i--) {
            bitValue = registerValue[i].value ? 1 : 0;
            sb.append(bitValue);
        }
        return sb.toString();
    }

    // вывод в десятичном представлении, при преобразовании рассматриваем значение как целое знаковое число.
    // Отрицательные числа хранятся в дополнительном коде.Старший бит дополнительного кода отвечает за знак числа
    public String toDecString() {
        int value = 0;
        int bitValue = 0;
        for (int i = 0; i < registerValue.length; i++) {
            bitValue = registerValue[i].value ? 1 : 0;
            bitValue <<= i;
            value += bitValue;
        }
        return Integer.toString(value);
    }
}

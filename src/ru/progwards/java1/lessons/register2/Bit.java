package ru.progwards.java1.lessons.register2;

public class Bit {

    public boolean value;

    public Bit() {
        this.value = false;
    }

    public Bit(boolean value) {
        this.value = value;
    }

    // должен выводить 1 или 0
    public String toString() {
        return this.value ? "1" : "0";
    }
}

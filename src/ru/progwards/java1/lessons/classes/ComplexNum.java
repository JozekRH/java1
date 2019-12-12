package ru.progwards.java1.lessons.classes;

public class ComplexNum {
    public int a;
    public int b;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "" + a + "+" + b + "i";
    }

    public ComplexNum add(ComplexNum num) {
        this.a += num.a;
        this.b += num.b;
        return this;
    }

    public ComplexNum sub(ComplexNum num) {
        this.a -= num.a;
        this.b -= num.b;
        return this;
    }

    public ComplexNum mul(ComplexNum num) {
        int oldA = this.a;
        int oldB = this.b;
        this.a = oldA * num.a - oldB*num.b;
        this.b = oldB * num.a + oldA * num.b;
        return this;
    }

    public ComplexNum div(ComplexNum num) {
        int oldA = this.a;
        int oldB = this.b;
        this.a = (oldA * num.a + oldB*num.b) / (num.a * num.a + num.b * num.b);
        this.b = (oldB * num.a - oldA * num.b) / (num.a * num.a + num.b * num.b);
        return this;
    }
}

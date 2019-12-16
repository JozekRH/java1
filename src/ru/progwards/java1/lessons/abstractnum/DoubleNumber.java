package ru.progwards.java1.lessons.abstractnum;

public class DoubleNumber extends Number {
    public double number;

    public DoubleNumber(double number) {
        this.number = number;
    }

    public Number mul(Number n1, Number n2) {
        double mulRes = ((DoubleNumber) n1).number * ((DoubleNumber) n2).number;
        return new DoubleNumber(mulRes);
    }

    public Number div(Number n1, Number n2) {
        double divRes = ((DoubleNumber) n1).number / ((DoubleNumber) n2).number;
        return new DoubleNumber(divRes);
    }

    public Number newNumber(String strNum) {
        double doubleNum = Double.parseDouble(strNum);
        return new DoubleNumber(doubleNum);
    }
}
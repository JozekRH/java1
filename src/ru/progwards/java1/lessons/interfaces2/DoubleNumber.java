package ru.progwards.java1.lessons.interfaces2;

import java.util.Objects;

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

    @Override
    public int compareTo(Number o) {
        DoubleNumber that = (DoubleNumber) o;
        return Double.compare(number, that.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
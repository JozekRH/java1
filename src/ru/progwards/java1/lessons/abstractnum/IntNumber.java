package ru.progwards.java1.lessons.abstractnum;

public class IntNumber extends Number {
    public int number;

    public IntNumber(int number) {
        this.number = number;
    }

    public Number mul(Number n1, Number n2) {
        int mulRes = ((IntNumber) n1).number * ((IntNumber) n2).number;
        return new IntNumber(mulRes);
    }

    public Number div(Number n1, Number n2) {
        int divRes = ((IntNumber) n1).number / ((IntNumber) n2).number;
        return new IntNumber(divRes);
    }

    public Number newNumber(String strNum) {
        Double doubleNum = Double.valueOf(strNum);
        int intNum = doubleNum.intValue();
        return new IntNumber(intNum);
    }
}

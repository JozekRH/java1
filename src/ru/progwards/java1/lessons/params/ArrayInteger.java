package ru.progwards.java1.lessons.params;

import java.math.BigInteger;

public class ArrayInteger {

    private int[] digits;
    
    public ArrayInteger(int n){
        this.digits = new int[n];
    }
    
    public void fromString(String value){

        for (int i = 0; i < value.length(); i++)
        {
            if (i >= digits.length) break;
            int di = i;
            if (digits.length > value.length()) di = digits.length - value.length() + i;
            digits[di] = Integer.valueOf(String.valueOf(value.toCharArray()[i]));
        }
    }

    public String toString(){

        String s = "";

        for (int i = 0; i < digits.length; i++)
        {
            s += String.valueOf(digits[i]);
        }

        return s;
    }

    public boolean add(ArrayInteger num){
        
        BigInteger bd = toInt().add(num.toInt());
        if (bd.toString().length() > digits.length) return false;
        this.digits = new int[bd.toString().length()];
        fromInt(bd);
        
        return true;
    }


    private void fromInt(BigInteger value){

        for (int i = 0; i < value.toString().length(); i++)
        {
            if (i >= digits.length) break;
            int di = i;
            if (digits.length > value.toString().length()) di = digits.length - value.toString().length() + i;
            digits[di] = Integer.valueOf(String.valueOf(value.toString().toCharArray()[i]));
        }
    }

    private BigInteger toInt(){

        String s = "";

        for (int i = 0; i < digits.length; i++)
        {
            s += String.valueOf(digits[i]);
        }

        return new BigInteger(s);
    }

}
package ru.progwards.java1.lessons.params;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class FloatNumber {

    private boolean sign;
    private long mantissa;
    private int exp;
    private DecimalFormat df = new DecimalFormat("0.############################################################################E0");


    public FloatNumber(boolean sign, long mantissa, int exp){
        this.sign = sign;
        this.mantissa = mantissa;
        this.exp = exp;
    }

    public FloatNumber(String num){
        BigDecimal bd = new BigDecimal(num);
        this.sign = bd.compareTo(BigDecimal.ZERO) >= 0;
        this.mantissa = Math.abs(bd.unscaledValue().longValue());
        this.exp = bd.scale();
    }

    public void fromDouble(double num){
        FloatNumber fn = new FloatNumber(String.valueOf(num));
        this.sign = fn.sign;
        this.mantissa = fn.mantissa;
        this.exp = fn.exp;
    }

    public String toString(){
        BigDecimal bd = new BigDecimal(mantissa).movePointLeft(exp);
        if (!sign) bd = bd.negate();
        return df.format(bd);
    }

    public double toDouble(){
        BigDecimal bd = new BigDecimal(mantissa).movePointLeft(exp);
        if (!sign) bd = bd.negate();
        return bd.doubleValue();
    }

    public void negative(){
        sign = !sign;
    }

    public FloatNumber add(FloatNumber num){
        BigDecimal bd = new BigDecimal(toString()).add(new BigDecimal(num.toString()));
        return new FloatNumber(bd.toString());
    }

    public FloatNumber sub(FloatNumber num){
        BigDecimal bd = new BigDecimal(toString()).subtract(new BigDecimal(num.toString()));
        FloatNumber fn = new FloatNumber(bd.toString());
        return fn;
    }
}

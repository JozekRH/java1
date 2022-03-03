package ru.progwards.java1.lessons.params;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {
	
	public static BigDecimal fastPow(BigDecimal num, int pow){
		
		return num.pow(pow);
	}
	
	public static BigInteger fibonacci(int n){
		
		BigInteger a = BigInteger.valueOf(1);
		BigInteger fibo = BigInteger.valueOf(0);
        int counter = 0;

        while (counter++ < n) {
        	BigInteger a1 = a;
            a = fibo;
            fibo = fibo.add(a1);
        }
        
        return fibo;
	}

}

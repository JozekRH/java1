package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {

    private static CacheInfo lastFibo = new CacheInfo();

    public static int fiboNumber(int n) { // возвращает n-ое число Фибоначчи
        if(n == lastFibo.n) {
            return lastFibo.fibo;
        }
        if(n == 1 || n == 2)
            return 1;
        int fib1 = 1;
        int fib2 = 1;
        for(int i = 3; i <= n; i++) {
            int oldFib2 = fib2;
            fib2 += fib1;
            fib1 = oldFib2;
        }
        lastFibo.n = n;
        lastFibo.fibo = fib2;
        return fib2;
    }

    public static class CacheInfo {
        public int n; // число, для которого рассчитываем Фибоначчи
        public int fibo; // результат расчета
    }

    public CacheInfo getLastFibo() {
        return lastFibo;
    }

    public void clearLastFibo() {
        lastFibo = null;
    }
}

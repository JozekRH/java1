package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class FiboMapCache {

    private Map<Integer, BigDecimal> fiboCache;
    private boolean cacheOn;

    public FiboMapCache(boolean cacheOn) {
        this.cacheOn = cacheOn;
        if (cacheOn) {
            fiboCache = new TreeMap<>();
        }
    }

    private BigDecimal solveFibonacci(int n) {
        if (n == 1 || n == 2)
            return BigDecimal.ONE;
        BigDecimal fib1 = new BigDecimal("1");
        BigDecimal fib2 = new BigDecimal("1");
        for (int i = 3; i <= n; i++) {
            BigDecimal oldFib2 = fib2;
            fib2 = fib2.add(fib1);
            fib1 = oldFib2;
        }
        return fib2;
    }

    public BigDecimal fiboNumber(int n) {
        if (cacheOn) {
            if (fiboCache.containsKey(n)) {
                return fiboCache.get(n);
            }
            // рассчитать и добавить в кэш
            BigDecimal newFiboNum = solveFibonacci(n);
            fiboCache.put(n, newFiboNum);
            return newFiboNum;
        }
        return solveFibonacci(n);
    }

    public void clearCahe() {
        fiboCache = null;
    }

    public static void test() {
        final int FIBO_NUMBERS = 1000;
        final int ITERATION_NUMBER = 100;
        FiboMapCache fiboMapCache = new FiboMapCache(true);
        FiboMapCache fiboMapNoCache = new FiboMapCache(false);


        long start = System.currentTimeMillis();
        for (int j = 0; j < ITERATION_NUMBER; j++) {
            for (int i = 1; i <= FIBO_NUMBERS; i++) {
                fiboMapCache.fiboNumber(i);
            }
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("fiboNumber cacheOn=true время выполнения " + end);

        start = System.currentTimeMillis();
        for (int j = 0; j < ITERATION_NUMBER; j++) {
            for (int i = 1; i <= FIBO_NUMBERS; i++) {
                fiboMapNoCache.fiboNumber(i);
            }
        }
        end = System.currentTimeMillis() - start;
        System.out.println("fiboNumber cacheOn=false время выполнения " + end);
    }

    public static void main(String[] args) {
        test();
    }

}

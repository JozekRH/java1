package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {

    public static void main(String[] args) {
        for(int i = 1; i <= 15; i++) {
            System.out.print(fiboNumber(i) + " ");
        }
        System.out.println();
        for(int i = 1; i < 101; i++) {
            for(int j = 1; j < 101; j++) {
                for(int k = 1; k < 101; k++) {
                    if(TriangleInfo.isTriangle(i, j, k) &&
                            !TriangleSimpleInfo.isEquilateralTriangle(i, j, k) &&
                            isGoldenTriangle(i, j, k)
                    ) {
                        System.out.print(getBase(i, j, k) + " " + getEdge(i, j, k) + " " + getEdge(i, j, k));
                        System.out.println();
                    }
                }
            }
        }
    }

    public static boolean containsDigit(int number, int digit) {
        while(number > 0) {
            int temp = number % 10;
            if(temp == digit)
                return true;
            number /= 10;
        }
        return false;
    }

    public static int fiboNumber(int n) {
        if(n == 1 || n == 2)
            return 1;
        int fib1 = 1;
        int fib2 = 1;
        for(int i = 3; i <= n; i++) {
            int oldFib2 = fib2;
            fib2 += fib1;
            fib1 = oldFib2;
        }
        return fib2;
    }

    public static boolean isGoldenTriangle(int a, int b, int c) {
        if(!TriangleInfo.isIsoscelesTriangle(a, b, c))
            return false;
        int base = getBase(a, b, c);
        int edge = getEdge(a, b, c);
        return (double)edge / (double)base > 1.61703 && (double)edge / (double)base < 1.61903;
    }

    public static int getBase(int a, int b, int c) {
        if(a == b) {
            return c;
        }
        if(a == c) {
            return b;
        }
        return a;
    }

    public static int getEdge(int a, int b, int c) {
        if(a == b || a == c) {
            return a;
        }
        return b;
    }
}

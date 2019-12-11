package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    public static boolean isTriangle(int a, int b, int c) {
        return (a < b + c) && (b < a + c) && (c < a + b);
    }

    public static boolean isRightTriangle(int a, int b, int c) {
        int squaredA = a * a;
        int squaredB = b * b;
        int squaredC = c * c;
        return squaredA == squaredB + squaredC ||
                squaredB == squaredA + squaredC ||
                squaredC == squaredA + squaredB;
    }

    public static boolean isIsoscelesTriangle(int a, int b, int c) {
        return a == b || a == c || b == c;
    }
}

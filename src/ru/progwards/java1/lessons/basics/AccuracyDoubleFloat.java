package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    public static final double PI = 3.14;
    public static final double EARTH_RADIUS = 6371.2;

    public static double volumeBallDouble(double radius) {
        return 4.0 / 3.0 * PI * radius * radius * radius;
    }

    public static float volumeBallFloat(float radius) {
        return 4.0f / 3.0f * (float)PI * radius * radius * radius;
    }

    public static double calculateAccuracy(double radius) {
        return volumeBallDouble(radius) - volumeBallFloat((float) radius);
    }
}

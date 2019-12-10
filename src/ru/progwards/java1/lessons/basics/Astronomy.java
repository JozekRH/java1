package ru.progwards.java1.lessons.basics;

public class Astronomy {
    public static final double PI = 3.14;
    public static final double EARTH_RADIUS = 6371.2;
    public static final double MERCURY_RADIUS = 2439.7;
    public static final double JUPITER_RADIUS = 71492.0;


    public static Double sphereSquare(Double r) {
        return 4.0 * PI * r * r;
    }

    public static Double earthSquare() {
        return sphereSquare(EARTH_RADIUS);
    }

    public static Double mercurySquare() {
        return sphereSquare(MERCURY_RADIUS);
    }

    public static Double jupiterSquare() {
        return sphereSquare(JUPITER_RADIUS);
    }

    public static Double earthVsMercury() {
        return earthSquare() / mercurySquare();
    }

    public static Double earthVsJupiter() {
        return earthSquare() / jupiterSquare();
    }
}

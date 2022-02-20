package ru.progwards.java1.lessons.interfaces1;

public class Circle implements Area{
    private double diameter;
    public Circle(double diameter){
        this.diameter = diameter;
    }

    @Override
    public double getArea() {
        return Math.PI * diameter * diameter;
    }
}

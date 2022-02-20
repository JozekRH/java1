package ru.progwards.java1.lessons.interfaces1;

public class Rectangle implements Area{
    private double width;
    private double length;

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }
}

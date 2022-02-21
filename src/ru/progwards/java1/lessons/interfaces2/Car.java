package ru.progwards.java1.lessons.interfaces2;

public class Car implements CompareWeight {
    private double weight;

    public Car(double weight){
        this.weight = weight;
    }

    @Override
    public double getWeight(){
        return weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeight) {
        if (this.getWeight() < smthHasWeight.getWeight()) return CompareWeight.CompareResult.LESS;
        else if (this.getWeight() > smthHasWeight.getWeight()) return CompareWeight.CompareResult.GREATER;
        else return CompareWeight.CompareResult.EQUAL;
    }

    @Override
    public String toString(){
        return "Это автомобиль грузоподъемностью " + weight + "";
    }
}

package ru.progwards.java1.lessons.classes;

public class Animal {
    private double weight;

    public Animal(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;
    }

    public double getFoodCoeff() {
        return 0.02;
    }

    public double calculateFoodWeight() {
        return this.weight * this.getFoodCoeff();
    }

    @Override
    public String toString() {
        return "I am " + this.getKind() + ", eat " + this.getFoodKind();
    }

    public String toStringFull() {
        return "I am " + this.getKind() + ", eat " + this.getFoodKind() + " " + this.calculateFoodWeight();
    }
}

package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    private int weight;

    public Food (int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }


    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Food food = (Food)smthHasWeigt;
        int res = Integer.compare(weight, food.weight);
        switch (res) {
            case 1: return CompareResult.GREATER;
            case -1: return CompareResult.LESS;
        }
        return CompareResult.EQUAL;
    }
}

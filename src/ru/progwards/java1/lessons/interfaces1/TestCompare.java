package ru.progwards.java1.lessons.interfaces1;

import java.util.Arrays;

public class TestCompare{
    public static void main(String[] args) {
        Animal[] a = new Animal[]{
        new Cow("Пеструшка", 350),
                new Cow("Рыжая", 250),
                new Duck("Даша", 3),
                new Duck("Маша", 3.5),
                new Hamster("Акакий", .25),
                new Hamster("Поликарп", .32)
        };
        int i = 1 / 0;
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

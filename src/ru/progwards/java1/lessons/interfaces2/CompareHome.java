package ru.progwards.java1.lessons.interfaces2;

public class CompareHome {

    public static boolean sameHome(Home h1, Home h2){
        boolean b = h1.getHome().equals(h2.getHome());
        System.out.println("Результат сравнения " + h1.getClass().getSimpleName() + " и " + h2.getClass().getSimpleName() + " равен " + b);
        return b;
    }

    public static void main(String[] args) {
        sameHome(new Cow(""), new Duck(""));
        sameHome(new Cow(""), new Hamster(""));
        sameHome(new Cow(""), new Hawk());
        sameHome(new Duck(""), new Hamster(""));
        sameHome(new Duck(""), new Hawk());
        sameHome(new Hamster(""), new Hawk());
    }
}

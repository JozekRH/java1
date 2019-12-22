package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Creator {
    public static Collection<Integer> fillEven(int n) {
        Collection<Integer> collection = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            collection.add(i*2);
        }
        return collection;
    }

    public static Collection<Integer> fillOdd(int n) {
        Collection<Integer> collection = new ArrayList<>();
        for(int i = n; i >= 1; i--) {
            collection.add(i*2-1);
        }
        return collection;
    }

    public static Collection<Integer> fill3(int n) {
        Collection<Integer> collection = new ArrayList<>();
        int trinityElement = 0;
        int num = 0;
        for(int i = 0; i < n; i++) {
            trinityElement++;
            switch (trinityElement) {
                case 1:
                    num = i;
                    break;
                case 2:
                    num = i*i;
                    break;
                case 3:
                    num = i*i*i;
                    trinityElement = 0;
                    break;
            }
            collection.add(num);
        }
        return collection;
    }
}

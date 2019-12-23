package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Creator {

    public static void main(String[] args) {
        System.out.println(fill3(3));
    }

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
        int index = 0;
        outer:
        while (true) {
            for(int i = 1; i <= 3; i++) {
                if(collection.size() == n*3)
                    return collection;
                int num = 1;
                for(int j = 0; j < i; j++) {
                    num *= index;
                }
                collection.add(num);
            }
            index++;
        }
    }
}

package ru.progwards.java1.lessons.arrays;

public class ArraySort {
    public static void sort(int[] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                int temp;
                if(a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}

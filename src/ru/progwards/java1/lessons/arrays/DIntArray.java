package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {
    private int[] arr;

    public DIntArray() {
        arr = new int[0];
    }

    public void add(int num) {
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        //arr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = num;
        arr = newArr;
    }

    public void atInsert(int pos, int num) {
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, pos);
        System.arraycopy(arr, pos, newArr, pos+1, arr.length-pos-1);
        newArr[pos] = num;
        arr = newArr;
    }

    public void atDelete(int pos) {
        int[] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 0, newArr, 0, pos);
        System.arraycopy(arr, pos+1, newArr, pos, arr.length-pos-1);
        arr = newArr;
    }

    public int at(int pos) {
        return arr[pos];
    }
}

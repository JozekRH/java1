package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {

    private T[][] array;
    private int nextRow = 0;
    private int nextCol = 0;

    MatrixIterator(T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return nextRow < array.length && nextCol < array[nextRow].length;
    }

    @Override
    public T next() {
        if(nextCol < array[nextRow].length) {
            return array[nextRow][nextCol++];
        } else {
            nextCol = 0;
            return array[++nextRow][nextCol++];
        }
    }
}

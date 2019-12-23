package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {

    public static void main(String[] args) {
        String[][] strArr = {{"Борис","Дмитрий"},{"Григорий","Борис","Василий"},{"Борис","Дмитрий","Борис"}};
        MatrixIterator<String> iterator = new MatrixIterator<>(strArr);
        while (iterator.hasNext()) {
            System.out.println(iterator.nextRow);
            System.out.println(strArr.length);
            System.out.println("------------");
            System.out.println(iterator.nextCol);
            System.out.println(strArr[iterator.nextRow].length);
            System.out.println("---------------");
            System.out.println(iterator.next());
            System.out.println("================");
        }

    }

    private T[][] array;
    private int nextRow = 0;
    private int nextCol = 0;

    MatrixIterator(T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return nextRow < array.length-1 && nextCol <= array[nextRow].length ||
                nextRow < array.length && nextCol < array[nextRow].length;
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

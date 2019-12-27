package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {
    public static void main(String[] args) {
        System.out.println(compareSort());
    }

    public static void mySort(Collection<Integer> data) {
        Integer[] arr = new Integer[data.size()];
        Integer[] arrData = data.toArray(arr);
        for(int i = 0; i < arrData.length; i++) {
            for(int j = i + 1; j < arrData.length; j++) {
                int temp;
                if(arrData[i] > arrData[j]) {
                    temp = arrData[i];
                    arrData[i] = arrData[j];
                    arrData[j] = temp;
                }
            }
        }
        data.clear();
        data.addAll(Arrays.asList(arrData));
    }

    public static void minSort(Collection<Integer> data) {
        Collection<Integer> newCollection = new ArrayDeque<>(data.size());
        while(!data.isEmpty()) {
            Integer minElem = Collections.min(data);
            newCollection.add(minElem);
            data.remove(minElem);
        }
        data.addAll(newCollection);
    }

    static void collSort(Collection<Integer> data) {
        List<Integer> list = new ArrayList<>(data);
        Collections.sort(list);
        data.clear();
        data.addAll(list);
    }

    public static Collection<String> compareSort() {
        final int ELEMENTS_NUM = 10000;
        List<Integer> list = new ArrayList<>(ELEMENTS_NUM);
        for(int i = 0; i < ELEMENTS_NUM; i++) {
            list.add(i);
        }
        PriorityQueue<SortType> funcQueueSortedByTime = new PriorityQueue<>();

        Collections.shuffle(list);
        long start = System.currentTimeMillis();
        mySort(list);
        long end = System.currentTimeMillis() - start;
        funcQueueSortedByTime.add(new SortType("mySort", end));
        System.out.println("mySort" + "   " + end);

        Collections.shuffle(list);
        start = System.currentTimeMillis();
        minSort(list);
        end = System.currentTimeMillis() - start;
        funcQueueSortedByTime.add(new SortType("minSort", end));
        System.out.println("minSort" + "   " + end);

        Collections.shuffle(list);
        start = System.currentTimeMillis();
        collSort(list);
        end = System.currentTimeMillis() - start;
        funcQueueSortedByTime.add(new SortType("collSort", end));
        System.out.println("collSort" + "   " + end);

        Queue<String> funcNameQueue = new ArrayDeque<>();
        while(!funcQueueSortedByTime.isEmpty()) {
            funcNameQueue.add(funcQueueSortedByTime.poll().sortName);
        }
        return funcNameQueue;
    }

    private static class SortType implements Comparable<SortType>{
        final String sortName;
        final long sortTime;
        SortType(final String sortName, final long sortTime) {
            this.sortName = sortName;
            this.sortTime = sortTime;
        }

        @Override
        public int compareTo(SortType o) {
            return Long.compare(this.sortTime, o.sortTime);
        }
    }
}

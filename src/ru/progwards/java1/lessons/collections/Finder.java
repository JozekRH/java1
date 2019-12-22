package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Finder {

    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        Iterator<Integer> iterator = numbers.iterator();
        Integer firstNum = iterator.next();
        Integer secondNum = iterator.next();
        Integer sum = firstNum + secondNum;
        int firstIndex = 0;
        int secondIndex = 1;
        int resFirstIndex = firstIndex;
        int resSecondIndex = secondIndex;
        while(iterator.hasNext()) {
            firstNum = secondNum;
            secondNum = iterator.next();
            firstIndex++;
            secondIndex++;
            if(sum > firstNum + secondNum) {
                sum = firstNum + secondNum;
                resFirstIndex = firstIndex;
                resSecondIndex = secondIndex;
            }
        }
        Collection<Integer> col = new ArrayList<>(2);
        col.add(resFirstIndex);
        col.add(resSecondIndex);
        return col;
    }

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        Collection<Integer> res = new ArrayList<>();
        Iterator<Integer> iterator = numbers.iterator();
        int left = iterator.next();
        int current = iterator.next();
        int right = iterator.next();
        while(iterator.hasNext()) {
            if(current > left && current > right) {
                res.add(current);
            }
            left = current;
            current = right;
            right = iterator.next();
        }
        return res;
    }

    public static boolean findSequence(Collection<Integer> numbers) {
        int size = numbers.size();
        for(int i = 1; i <= size; i++) {
            if(!numbers.contains(i))
                return false;
        }
        return true;
    }

    public static String findSimilar(Collection<String> names) {
        List<String> nameSet = new ArrayList<>();
        List<Integer> nameCounter = new ArrayList<>();
        Iterator<String> iterator = names.iterator();
        String currentName = "";
        outer:
        while (iterator.hasNext()) {
            currentName = iterator.next();
            for (int i = 0; i < nameSet.size(); i++) {
                if(currentName.equals(nameSet.get(i))) {
                    nameCounter.set(i, nameCounter.get(i)+1);
                    continue outer;
                }
            }
            nameSet.add(currentName);
            nameCounter.add(1);
        }
        int maxRepeat = 0;
        int indexMaxRepeat = 0;
        int currentRepeat = 0;
        for (int i = 0; i < nameCounter.size(); i++) {
            currentRepeat = nameCounter.get(i);
            if(maxRepeat < currentRepeat) {
                maxRepeat = currentRepeat;
                indexMaxRepeat = i;
            }
        }
        return nameSet.get(indexMaxRepeat) + ":" + maxRepeat;
    }
}

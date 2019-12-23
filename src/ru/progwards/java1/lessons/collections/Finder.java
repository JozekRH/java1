package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Finder {

    public static void main(String[] args) {
        int[] numArr = {-87,-51,11,43,-71,44,97,-51};
        Collection<Integer> nums = new ArrayList<>();
        for (Integer number : numArr) {
            nums.add(number);
        }
        System.out.println(findLocalMax(nums));

        String[] strArr = {"Борис", "Дмитрий", "Александр", "Александр", "Александр", "Борис", "Григорий",
                "Борис"};
        Collection<String> namesCol = new ArrayList<>(Arrays.asList(strArr));
        System.out.println(findSimilar(namesCol));
    }

    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        Iterator<Integer> iterator = numbers.iterator();
        Integer firstNum = iterator.next();
        Integer secondNum = iterator.next();
        Integer sum = firstNum + secondNum;
        int firstIndex = 0;
        int secondIndex = 1;
        int resFirstIndex = firstIndex;
        int resSecondIndex = secondIndex;
        while (iterator.hasNext()) {
            firstNum = secondNum;
            secondNum = iterator.next();
            firstIndex++;
            secondIndex++;
            if (sum > firstNum + secondNum) {
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
        int left;
        int current = iterator.next();
        int right = iterator.next();
        while (iterator.hasNext()) {
            left = current;
            current = right;
            right = iterator.next();
            if (current > left && current > right) {
                res.add(current);
            }
        }
        return res;
    }

    public static boolean findSequence(Collection<Integer> numbers) {
        int size = numbers.size();
        for (int i = 1; i <= size; i++) {
            if (!numbers.contains(i))
                return false;
        }
        return true;
    }

    public static String findSimilar(Collection<String> names) {
        LinkedList<String> nameStack = new LinkedList<>();
        int nameCount = 0;
        int maxNameCount = 0;
        Iterator<String> iterator = names.iterator();
        String currentName = "";
        while (iterator.hasNext()) {
            currentName = iterator.next();
            if (currentName.equals(nameStack.peek())) {
                nameCount++;
            } else {
                if (nameCount > maxNameCount) {
                    maxNameCount = nameCount;
                } else {
                    nameStack.poll();
                }
                nameCount = 1;
                nameStack.push(currentName);
            }
        }
        if(nameCount > maxNameCount) {
            maxNameCount = nameCount;
        } else {
            nameStack.poll();
        }
        System.out.println(nameStack);
        System.out.println(maxNameCount);
        return nameStack.peek() + ":" + maxNameCount;
    }
}

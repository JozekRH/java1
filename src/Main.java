
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        checkAndAdd(map, 0, "zero");
        checkAndAdd(map, 0, "replacedZero");
        checkAndAdd(map, 1, "one");
        checkAndAdd(map, 2, "one");
        System.out.println(map);
    }

    static void pqTest() {
        PriorityQueue pQueue = new PriorityQueue<>();
        pQueue.offer(10);
        pQueue.offer(1);
        pQueue.offer(9);
        pQueue.offer(3);
        System.out.println(pQueue);
    }

    int fillHoles(Map<Integer, String> map, int size) {
        int counter = 0;
        for(int i = 1; i <= size; i++) {
            if(!map.containsKey(i)) {
                map.put(i, "Число " + i);
                counter++;
            }
        }
        return counter;
    }

    static void checkAndAdd(TreeMap<Integer, String> map, Integer key, String value) {
        if(!map.containsKey(key)) {
            if (map.size() < 2) {
                map.put(key, value);
            } else {
                if(key > map.firstKey() && key < map.lastKey()) {
                    map.put(key, value);
                }
            }
        }
    }
}

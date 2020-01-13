package ru.progwards.java1.lessons.datetime;

import java.time.Instant;
import java.util.*;

public class Profiler {

    private static Deque<Long> sectionStartTimeDeque = new ArrayDeque<>();
    private static Deque<String> sectionNameDeque = new ArrayDeque<>();
    //private static List<StatisticInfo> sectionList = new ArrayList<>();
    private static LinkedHashMap<String, StatisticInfo> sectionMap = new LinkedHashMap<>();

    public static void enterSection(String name) {
//        if(isAbsentSectionInList(name))
//            sectionList.add(new StatisticInfo(name));
        sectionMap.putIfAbsent(name, new StatisticInfo(name));
        sectionStartTimeDeque.push(Instant.now().toEpochMilli());
        sectionNameDeque.push(name);
    }
    
//    private static boolean isAbsentSectionInList(String name) {
//        for (StatisticInfo section : sectionList) {
//            if(section.sectionName.equals(name))
//                return false;
//        }
//        return true;
//    }

    public static void exitSection(String name) {
        int period = (int)(Instant.now().toEpochMilli() - sectionStartTimeDeque.pop());
        sectionMap.get(name).count++;
        sectionMap.get(name).fullTime += period;
        sectionMap.get(name).selfTime += period;
        sectionNameDeque.pop();
        if(!sectionNameDeque.isEmpty()) {
            String externalSectionName = sectionNameDeque.peek();
            sectionMap.get(externalSectionName).selfTime -= period;
        }
    }

    public static List<StatisticInfo> getStatisticInfo() {
        return (List<StatisticInfo>)sectionMap.values();
    }

}

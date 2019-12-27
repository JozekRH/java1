package ru.progwards.java1.lessons.queues;

import java.math.BigDecimal;

public class Order implements Comparable<Order> {
    private double sum;
    private BigDecimal priorityLevel;

    public Order(double sum) {
        this.sum = sum;
    }

    public double getSum() {
        return this.sum;
    }

    public void setPriorityLevel(BigDecimal priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @Override
    public int compareTo(Order o) {
        return priorityLevel.compareTo(o.priorityLevel);
    }
}

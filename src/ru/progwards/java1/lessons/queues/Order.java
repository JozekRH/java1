package ru.progwards.java1.lessons.queues;

public class Order implements Comparable<Order> {
    private double sum;
    private int priorityLevel;

    public Order(double sum) {
        this.sum = sum;
    }

    public double getSum() {
        return this.sum;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @Override
    public int compareTo(Order o) {
        return Long.compare(this.priorityLevel, o.priorityLevel);
    }
}

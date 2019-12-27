package ru.progwards.java1.lessons.queues;

import java.util.PriorityQueue;

public class OrderQueue {
    private PriorityQueue<Order> orderPriorityQueue;

    public OrderQueue() {
        this.orderPriorityQueue = new PriorityQueue<>();
    }

    public void add(Order order) {
        double sum = order.getSum();

        if(sum <= 10000.0) {
            order.setPriorityLevel(3);
        } else if(sum > 10000.0 && sum <= 20000.0) {
            order.setPriorityLevel(2);
        } else {
            order.setPriorityLevel(1);
        }
        orderPriorityQueue.offer(order);
    }

    public Order get() {
        return orderPriorityQueue.poll();
    }
}

package ru.progwards.java1.lessons.queues;

import java.math.BigDecimal;
import java.util.PriorityQueue;

public class OrderQueue {
    private PriorityQueue<Order> orderPriorityQueue;
    private BigDecimal firstPriority;
    private BigDecimal secondPriority;
    private BigDecimal thirdPriority;
    private BigDecimal counter;
    private BigDecimal firstMaxBoundary;
    private BigDecimal secondMaxBoundary;
    private BigDecimal thirdMaxBoundary;

    public OrderQueue() {
        this.orderPriorityQueue = new PriorityQueue<>();
        firstPriority = BigDecimal.ONE;
        secondPriority = new BigDecimal("2");
        thirdPriority = new BigDecimal("3");
        counter = new BigDecimal("0.000001");
        firstMaxBoundary = new BigDecimal("2");
        secondMaxBoundary = new BigDecimal("3");
        thirdMaxBoundary = new BigDecimal("4");
    }

    public void add(Order order) {
        double sum = order.getSum();

        if(sum <= 10000.0) {
            if(thirdPriority.add(counter).compareTo(thirdMaxBoundary) >= 0) {
                counter = counter.multiply(new BigDecimal("0.001"));
            }
            thirdPriority = thirdPriority.add(counter);
            order.setPriorityLevel(thirdPriority);
        } else if(sum > 10000.0 && sum <= 20000.0) {
            if(secondPriority.add(counter).compareTo(secondMaxBoundary) >= 0) {
                counter = counter.multiply(new BigDecimal("0.001"));
            }
            secondPriority = secondPriority.add(counter);
            order.setPriorityLevel(secondPriority);
        } else {
            if(firstPriority.add(counter).compareTo(firstMaxBoundary) >= 0) {
                counter = counter.multiply(new BigDecimal("0.001"));
            }
            firstPriority = firstPriority.add(counter);
            order.setPriorityLevel(firstPriority);
        }
        orderPriorityQueue.offer(order);
    }

    public Order get() {
        return orderPriorityQueue.poll();
    }
}

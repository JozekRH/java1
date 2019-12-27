package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;

public class StackCalc {
    private ArrayDeque<Double> stack;

    public StackCalc() {
        stack = new ArrayDeque<>();
    }

    public void push(double value) {
        stack.push(value);
    }

    public double pop() {
        return stack.pop();
    }

    public void add() {
        double sum = stack.pop();
        sum += stack.pop();
        stack.push(sum);
    }

    public void sub() {
        double first = stack.pop();
        double second = stack.pop();
        stack.push(second - first);
    }

    public void mul() {
        double multiplication = stack.pop();
        multiplication *= stack.pop();
        stack.push(multiplication);
    }

    public void div() {
        double first = stack.pop();
        double second = stack.pop();
        stack.push(second / first);
    }
}

package Leetcode.stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        // Creating an instance of MinStack
        MinStack minStack = new MinStack();

        // Demonstrating the push operation
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        // Getting the minimum element after pushing -2, 0, -3
        System.out.println("Minimum element: " + minStack.getMin()); // Output: -3

        // Popping the top element (-3)
        minStack.pop();

        // Getting the top element after pop
        System.out.println("Top element: " + minStack.top()); // Output: 0

        // Getting the minimum element after popping
        System.out.println("Minimum element: " + minStack.getMin()); // Output: -2
    }
}

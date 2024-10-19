package Queue;

import java.util.Stack;

public class QueueUsingTwoStack {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    QueueUsingTwoStack(){
        stack1=new Stack<>();
        stack2=new Stack<>();

    }

    public void enqueue(int x){
        stack1.push(x);
    }

    public int dequeue(){
        if(stack2.isEmpty()){
            // Move all elements from stack1 to stack2 if stack2 is empty
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        // If stack2 is still empty, the queue is empty
        if(stack2.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }

        return stack2.pop();
    }

    // Method to peek the front element of the queue without removing it
    public int peek() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        // If stack2 is still empty, the queue is empty
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return stack2.peek();
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingTwoStack queue = new QueueUsingTwoStack();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue()); // Outputs 10
        System.out.println(queue.peek());    // Outputs 20
        System.out.println(queue.dequeue()); // Outputs 20
        System.out.println(queue.isEmpty()); // Outputs false
        System.out.println(queue.dequeue()); // Outputs 30
        System.out.println(queue.isEmpty()); // Outputs true

    }

}

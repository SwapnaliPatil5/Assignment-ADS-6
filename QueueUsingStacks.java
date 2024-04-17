package assignment6;

import java.util.Stack;

class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Push element x to the back of queue.
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Removes the element from the front of queue and returns that element.
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Get the front element.
    public int front() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Returns whether the queue is empty.
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

 class Main4 {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        System.out.println("Front element: " + queue.front());
        
        queue.dequeue();
        
        System.out.println("Front element after dequeue: " + queue.front());
    }
}

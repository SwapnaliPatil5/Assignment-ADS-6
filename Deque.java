package assignment6;

class Deque {
    int[] arr;
    int front;
    int rear;
    int size;
    
    public Deque(int size) {
        arr = new int[size];
        front = -1;
        rear = 0;
        this.size = size;
    }

    // Checks whether Deque is full or not.
    boolean isFull() {
        return ((front == 0 && rear == size - 1) || front == rear + 1);
    }

    // Checks whether Deque is empty or not.
    boolean isEmpty() {
        return (front == -1);
    }

    // Inserts an element at front.
    void insertFront(int key) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        if (front == -1) { // First Element
            front = 0;
            rear = 0;
        } else if (front == 0) { // Circular increment
            front = size - 1;
        } else { // Decrement front end
            front = front - 1;
        }
        arr[front] = key;
    }

    // Inserts an element at rear.
    void insertRear(int key) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        if (front == -1) { // First Element
            front = 0;
            rear = 0;
        } else if (rear == size - 1) { // Circular increment
            rear = 0;
        } else { // Increment rear end
            rear = rear + 1;
        }
        arr[rear] = key;
    }

    // Deletes an element from front.
    int deleteFront() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int data = arr[front];
        if (front == rear) { // Only one element
            front = -1;
            rear = -1;
        } else if (front == size - 1) { // Circular decrement
            front = 0;
        } else { // Increment front
            front = front + 1;
        }
        return data;
    }

    // Deletes an element from rear.
    int deleteRear() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int data = arr[rear];
        if (front == rear) { // Only one element
            front = -1;
            rear = -1;
        } else if (rear == 0) { // Circular decrement
            rear = size - 1;
        } else { // Decrement rear
            rear = rear - 1;
        }
        return data;
    }

    // Get the front item from the queue.
    int getFront() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return arr[front];
    }

    // Get the rear item from the queue.
    int getRear() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return arr[rear];
    }
}

 class Main1 {
    public static void main(String[] args) {
        Deque dq = new Deque(5);
        
        System.out.println("Insert element at rear end : 5 ");
        dq.insertRear(5);
        
        System.out.println("insert element at front end : 3 ");
        dq.insertFront(3);
        
        System.out.println("Front element: " + dq.getFront());
        System.out.println("Rear element: " + dq.getRear());
        
        dq.deleteFront();
        System.out.println("After deleting front element, new front is: " + dq.getFront());
        
        dq.insertRear(7);
        System.out.println("After inserting element at rear, new rear is: " + dq.getRear());
        
        dq.deleteRear();
        System.out.println("After deleting rear element, new rear is: " + dq.getRear());
    }
}

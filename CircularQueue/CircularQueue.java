package CircularQueue;


import java.util.ArrayList;
import java.util.Scanner;

class CircularQueue {
    private int size, front, rear; 
    private ArrayList<Integer> queue = new ArrayList<Integer>(); 

    CircularQueue(int size) { 
        this.size = size;
        this.front = this.rear = -1;
    }

    public void enQueue(int data) { 
       
        if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
            System.out.print("Queue is Full");
        } else if (front == -1) { 
            front = 0;
            rear = 0;
            queue.add(rear, data);
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            queue.set(rear, data);
        } else {
            rear = (rear + 1);
            if (front <= rear) {
                queue.add(rear, data); 
            } else {
                queue.set(rear, data);
            }
        }
    }

    public int deQueue() { 
        int temp;
        if (front == -1) { 
            System.out.print("Queue is Empty");
            return -1; 
        }
        temp = queue.get(front);
        if (front == rear) { 
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front = front + 1;
        }
        return temp; 
    }

    public void displayQueue() { 
        if (front == -1) {
            System.out.print("Queue is Empty");
            return;
        }
    
        System.out.print("Elements in the " + "circular queue are: ");
        if (rear >= front) {
            for (int i = front; i <= rear; i++) { 
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        } else { 
            for (int i = front; i < size; i++) { 
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            for (int i = 0; i <= rear; i++) { 
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5); // Initialize the CircularQueue object
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the element number to enqueue: ");
                    int data = scanner.nextInt();
                    q.enQueue(data);
                    break;
                case 2:
                    int dequeuedValue = q.deQueue();
                    if (dequeuedValue != -1) {
                        System.out.println("Dequeued value: " + dequeuedValue);
                    }
                    break;
                case 3:
                    q.displayQueue();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    System.out.println("Try Again!");
                    continue;
            }
        }
    }
}
package CircularArrayQueue;

import CircularArrayQueue.exceptions.EmptyCollectionException;

/**
 * Test class to demonstrate the functionality of CircularArrayQueue.
 */
public class CircularArrayQueueTest {

    public static void main(String[] args) {
        CircularArrayQueue<String> queue = new CircularArrayQueue<>(3);

        System.out.println("Testing CircularArrayQueue");

        // 1. Enqueue and check size/toString
        System.out.println("\n1. Testing enqueue:");
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("Queue after 3 enqueues: " + queue);
        System.out.println("Size: " + queue.size());

        // 2. Testing expandCapacity (should expand capacity to 6)
        queue.enqueue("D");
        System.out.println("\n2. Testing expandCapacity:");
        System.out.println("Queue after 4th enqueue: " + queue);
        System.out.println("Size: " + queue.size());

        // 3. Testing first (peek)
        System.out.println("\n3. Testing first (peek):");
        try {
            String firstElement = queue.first();
            System.out.println("First element: " + firstElement);
            System.out.println("Queue after first: " + queue);
        } catch (EmptyCollectionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 4. Testing dequeue
        System.out.println("\n4. Testing dequeue:");
        try {
            String removed1 = queue.dequeue();
            String removed2 = queue.dequeue();
            System.out.println("Removed A, then B.");
            System.out.println("Queue after 2 dequeues: " + queue);
            System.out.println("Size: " + queue.size());
        } catch (EmptyCollectionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 5. Demonstrating circularity and filling
        System.out.println("\n5. Demonstrating circularity and filling:");
        queue.enqueue("E");
        queue.enqueue("F");
        System.out.println("Queue after enqueue E and F: " + queue);

        // 6. Testing isEmpty
        System.out.println("\n6. Testing isEmpty:");
        System.out.println("Is the queue empty? " + queue.isEmpty());

        // 7. Emptying the queue completely and testing exceptions
        System.out.println("\n7. Testing exceptions:");
        try {
            System.out.print("Removed elements: ");
            while (!queue.isEmpty()) {
                System.out.print(queue.dequeue() + " ");
            }
            System.out.println("\nQueue is completely emptied.");
        } catch (EmptyCollectionException e) {
        }

        // 8. Checking EmptyCollectionException for dequeue
        try {
            queue.dequeue();
        } catch (EmptyCollectionException e) {
            System.out.println("Successful dequeue exception check: " + e.getMessage());
        }

        // 9. Checking EmptyCollectionException for first
        try {
            queue.first();
        } catch (EmptyCollectionException e) {
            System.out.println("Successful first exception check: " + e.getMessage());
        }
    }
}
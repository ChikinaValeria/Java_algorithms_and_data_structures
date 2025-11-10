package QueueUsingArrayList;

import java.util.NoSuchElementException;

public class QueueTest
{
    public static void main(String[] args)
    {
        System.out.println("Testing ArrayQueue Implementation");

        QueueADT<String> queue = new ArrayQueue<>();

        System.out.println("Is queue empty? " + queue.isEmpty());

        System.out.println("\n Enqueue Elements");
        queue.enqueue("Onni");
        System.out.println("Enqueued: Onni");
        queue.enqueue("Harri");
        System.out.println("Enqueued: Harri");
        queue.enqueue("Pekka");
        System.out.println("Enqueued: Pekka");


        System.out.println(queue.toString());
        System.out.println("Queue size: " + queue.size());

        try {
            System.out.println("\nFirst element (peek): " + queue.first());
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("\n Dequeue Elements");
        try {
            System.out.println("Dequeued: " + queue.dequeue());
            System.out.println("Dequeued: " + queue.dequeue());
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(queue.toString());
        System.out.println("Queue size: " + queue.size());

        System.out.println("\nFinal Dequeue: " + queue.dequeue());
        System.out.println("Is queue empty? " + queue.isEmpty());

        try {
            System.out.println("\nTrying to dequeue from empty queue.");
            queue.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}

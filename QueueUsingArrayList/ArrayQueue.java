package QueueUsingArrayList;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayQueue<T> implements QueueADT<T>
{
    private ArrayList<T> queue;

    public ArrayQueue() {
        queue = new ArrayList<T>();
    }

    @Override
    public void enqueue(T element) {
        queue.add(element);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty. Impossible to dequeue.");
        }
        return queue.remove(0);
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty. Impossible to return first element.");
        }
        return queue.get(0);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public String toString() {
        return "Queue: " + queue.toString();
    }
}
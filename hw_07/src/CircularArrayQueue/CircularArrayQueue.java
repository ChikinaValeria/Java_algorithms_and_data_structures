package CircularArrayQueue;

import CircularArrayQueue.exceptions.EmptyCollectionException;


/**
 * CircularArrayQueue represents an array implementation of a queue in
 * which the indexes for the front and rear of the queue circle back to 0
 * when they reach the end of the array.
 *
 * NOTE: The count attribute has been removed. Size is now calculated using front and rear.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class CircularArrayQueue<T> implements QueueADT<T>
{
    private final static int DEFAULT_CAPACITY = 100;
    // Removed 'count' attribute
    private int front, rear;
    private T[] queue;

    /**
     * Creates an empty queue using the specified capacity.
     * @param initialCapacity the initial size of the circular array queue
     */
    public CircularArrayQueue (int initialCapacity)
    {
        front = rear = 0; // 'count' initialization removed
        queue = (T[]) (new Object[initialCapacity]);
    }

    /**
     * Creates an empty queue using the default capacity.
     */
    public CircularArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Adds the specified element to the rear of this queue, expanding
     * the capacity of the queue array if necessary.
     * @param element the element to add to the rear of the queue
     */
    @Override
    public void enqueue(T element)
    {
        if (size() == queue.length)
            expandCapacity();

        queue[rear] = element;
        rear = (rear+1) % queue.length;

    }

    private void expandCapacity()
    {
        T[] larger = (T[]) (new Object[queue.length *2]);
        int currentCount = size();

        for (int scan = 0; scan < currentCount; scan++)
        {
            larger[scan] = queue[front];
            front = (front + 1) % queue.length;
        }

        front = 0;
        rear = currentCount;
        queue = larger;
    }

    /**
     * Removes the element at the front of this queue and returns a
     * reference to it.
     * @return the element removed from the front of the queue
     * @throws EmptyCollectionException  if the queue is empty
     */
    @Override
    public T dequeue() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("queue");

        T result = queue[front];
        queue[front] = null;
        front = (front+1) % queue.length;

        return result;
    }

    /**
     * Returns without removing the element at the front of this queue.
     * @return the first element in the queue
     * @throws EmptyCollectionException  if the queue is empty
     */
    @Override
    public T first() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("Queue");

        return queue[front];
    }

    /**
     * Returns true if this queue contains no elements.
     * @return true if this queue is empty
     */
    @Override
    public boolean isEmpty()
    {
        return (front == rear) && (size() == 0);
    }

    /**
     * Returns the number of elements in this queue.
     * @return the integer representation of the size of the queue
     */
    @Override
    public int size()
    {
        if (front == rear && queue[front] == null) {
            return 0;
        } else if (front == rear && queue[front] != null && queue.length == 1) {
            return 1;
        } else if (front == rear && queue[front] != null) {
            int currentSize = (rear - front + queue.length) % queue.length;

            if (currentSize == 0 && (queue[front] != null || front != rear)) {
                return queue.length;
            }
            return currentSize;
        }

        if (rear > front) {
            // No wrap-around
            return rear - front;
        } else {
            // Wrap-around
            return (queue.length - front) + rear;
        }
    }

    /**
     * Returns a string representation of this queue.
     * @return the string representation of the queue
     */
    @Override
    public String toString()
    {
        if (isEmpty())
            return "Queue is empty.";

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        int currentCount = size();

        // Iterate through elements from front to rear with circularity
        int scan = front;
        for (int i = 0; i < currentCount; i++)
        {
            sb.append(queue[scan].toString());
            if (i < currentCount - 1)
                sb.append(", ");
            scan = (scan + 1) % queue.length;
        }

        sb.append("]");
        return sb.toString();
    }
}
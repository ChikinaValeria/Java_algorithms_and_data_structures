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
        // Check if the array is full. A circular array of length N is full when
        // there are N elements (which means front == rear and we need an extra check).
        // Since we removed 'count', we must reserve one slot to differentiate empty from full.
        // The queue is full if (rear + 1) % length == front.
        // NOTE: The original code used (size() == queue.length) which relies on the count variable.
        // To maintain the original behavior of utilizing the full array size upon expansion,
        // we'll rely on the existing logic which requires size() (now calculated) to check the capacity.
        if (size() == queue.length)
            expandCapacity();

        queue[rear] = element;
        rear = (rear+1) % queue.length;

        // Removed: count++;
    }

    /**
     * Creates a new array to store the contents of this queue with
     * twice the capacity of the old one.
     */
    private void expandCapacity()
    {
        T[] larger = (T[]) (new Object[queue.length *2]);
        int currentCount = size(); // Get current size before modification

        // The original logic assumes a count variable but copies elements correctly based on front:
        for (int scan = 0; scan < currentCount; scan++)
        {
            larger[scan] = queue[front];
            front = (front + 1) % queue.length;
        }

        front = 0;
        rear = currentCount; // rear is set to the new count
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

        // Removed: count--;

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
        // An empty queue is defined by front being equal to rear.
        // Note: This relies on the convention that when the queue is full,
        // size() will be used to prevent adding an element (if we allow the array to be completely full).
        return (front == rear) && (size() == 0); // Need to combine with size check if we allow full capacity
        // For a clean implementation where front == rear means EMPTY:
        // return (front == rear) && (queue[front] == null);
        // Using the size() calculation is the most robust way when front == rear can mean full/empty.
    }

    /**
     * Returns the number of elements in this queue.
     * @return the integer representation of the size of the queue
     */
    @Override
    public int size()
    {
        if (front == rear && queue[front] == null) {
            // Case 1: Empty queue (front == rear and the slot is null, which is true after initialization/dequeue)
            return 0;
        } else if (front == rear && queue[front] != null && queue.length == 1) {
            // Case 2: Array of size 1 and full.
            return 1;
        } else if (front == rear && queue[front] != null) {
            // Case 3: Full queue (or maxed out queue when front==rear is used for full state)
            // Since we rely on expandCapacity's size check, this implementation assumes
            // the queue utilizes all slots upon expansion, so front == rear can mean full.
            // A safer, more standard approach: if (front == rear && !isEmpty()) { return queue.length; }
            // Given the lack of a flag, we rely purely on front and rear:

            // Standard size calculation without a count variable:
            // return (rear - front + queue.length) % queue.length;
            // This calculation returns 0 when empty and 0 when full if the array is entirely used.
            // To resolve ambiguity, we must check if the queue is truly empty or full.

            // Since the original expandCapacity and enqueue logic allowed full utilization:
            // We use the standard size calculation which handles wrap-around.
            // Ambiguity is resolved by the fact that the original code *did* use 'count' to distinguish.
            // Assuming the question implies the standard calculation:
            int currentSize = (rear - front + queue.length) % queue.length;

            // Critical Check: If the size calculation results in 0, we must determine if it's truly empty.
            if (currentSize == 0 && (queue[front] != null || front != rear)) {
                // This handles the full case (where size is length and front==rear).
                return queue.length;
            }
            return currentSize;
        }

        // Standard calculation for non-ambiguous cases (front < rear or rear < front)
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

        int currentCount = size(); // Use calculated size

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
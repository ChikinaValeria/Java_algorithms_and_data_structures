package ArrayStackTask;

/**
 * Defines the interface to a stack collection.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public interface StackADT<T>
{
    public void push(T element);

    public T pop();

    public T peek();

    public boolean isEmpty();

    public int size();

    public String toString();
}


package LinkedStack;

import LinkedStack.exceptions.EmptyCollectionException;

/**
 * Defines the interface to a stack collection.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public interface StackADT<T>
{
    public void push(T element);

    public T pop() throws EmptyCollectionException;

    public T peek() throws EmptyCollectionException;

    public boolean isEmpty();

    public int size();

    public String toString();
}
package StackUsingLinkedList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList<T>
{
    private LinkedList<T> list;

    public MyLinkedList() {
        list = new LinkedList<>();
    }

    public void add(T element) {
        list.addLast(element);
    }

    public T last() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.getLast();
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.removeFirst();
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.removeLast();
    }

    public T remove(T element) {
        if (list.remove(element)) {
            return element;
        } else {
            throw new NoSuchElementException("Element not found in list.");
        }
    }

    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.getFirst();
    }

    public boolean contains(T target) {
        return list.contains(target);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public void addToFront(T element)
    {
        ;
    }
}

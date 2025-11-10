package StackUsingLinkedList;

import java.util.NoSuchElementException;

public class MyStack<T>
{
    private MyLinkedList<T> data;

    public MyStack() {
        data = new MyLinkedList<>();
    }

    public void push(T element) {
        data.add(element);
    }

    public T pop() {
        try {
            return data.removeLast();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Stack is empty.");
        }
    }

    public T peek() {
        try {
            return data.last();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Stack is empty.");
        }
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }

    @Override
    public String toString() {
        return "Stack Contents: " + data.toString();
    }
}
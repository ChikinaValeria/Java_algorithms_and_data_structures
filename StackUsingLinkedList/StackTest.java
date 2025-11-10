package StackUsingLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackTest
{
    public static void main(String[] args)
    {
        System.out.println("Testing MyStack methods");
        MyStack<String> stack = new MyStack<>();

        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.push("Anna");
        stack.push("Leena");
        stack.push("Maria");

        System.out.println(stack.toString());
        System.out.println("Stack size: " + stack.size());

        try {
            System.out.println("Peeked (top element): " + stack.peek());
            System.out.println("Popped: " + stack.pop());
            System.out.println("Popped: " + stack.pop());
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Current stack: " + stack.toString());

        stack.push("Lumi");
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Final pop: " + stack.pop());
        System.out.println("Final pop: " + stack.pop());

        try {
            System.out.println("Attempting to pop from empty stack...");
            stack.pop(); // throws exception
        } catch (NoSuchElementException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }


        System.out.println("\n Testing MyLinkedList Methods");
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(13);
        list.add(28);
        list.add(34);
        System.out.println("Initial List: " + list.toString());


        System.out.println("First element: " + list.first());
        System.out.println("Last element: " + list.last());

        System.out.println("List contains 28? " + list.contains(28));
        System.out.println("List size: " + list.size());

        try {
            System.out.println("Removed element 28: " + list.remove(28));
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("After remove(28): " + list.toString());

        System.out.println("Removed last: " + list.removeLast());
        System.out.println("After removeLast: " + list.toString());

        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("Final list: " + list.toString());


        list.add(5);
        list.add(15);
        Iterator<Integer> it = list.iterator();
        System.out.print("Iterating list: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}

package ArrayStackTask;

import ArrayStackTask.exceptions.EmptyCollectionException;

public class Main {
    public static void main(String[] args) {
        StackADT<String> stack = new ArrayStack<>(3);

        System.out.println("Checking if the stack is empty at the beginning: " + stack.isEmpty());
        System.out.println("Current stack size: " + stack.size());

        System.out.println("\nAdding elements to the stack...");
        stack.push("First element");
        stack.push("Second element");
        stack.push("Third element");

        System.out.println("Current stack size before adding a new element: " + stack.size());

        System.out.println("Adding a fourth element, which should trigger capacity expansion...");
        stack.push("Fourth element");

        System.out.println("Current stack size after expansion: " + stack.size());
        System.out.println("Stack content: " + stack.toString());

        try {
            System.out.println("\nTop element without removing: " + stack.peek());
            System.out.println("Removing the top element: " + stack.pop());
            System.out.println("Removing the top element: " + stack.pop());
            System.out.println("Removing the top element: " + stack.pop());
            System.out.println("Removing the top element: " + stack.pop());
            System.out.println("\nRemoving one more element...");

            System.out.println("Top element: " + stack.pop());
        } catch (EmptyCollectionException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}


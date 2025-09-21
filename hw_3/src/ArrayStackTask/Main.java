package ArrayStackTask;

import ArrayStackTask.exceptions.EmptyCollectionException;

public class Main {
    public static void main(String[] args) {
        StackADT<String> stack = new ArrayStack<>();

        System.out.println("Checking if the stack is empty at the beginning: " + stack.isEmpty());
        System.out.println("Current stack size: " + stack.size());

        System.out.println("\nAdding elements to the stack...");
        stack.push("First element");
        stack.push("Second element");
        stack.push("Third element");

        System.out.println("Checking if the stack is empty after adding: " + stack.isEmpty());
        System.out.println("Current stack size: " + stack.size());

        // Using the toString() method to see the stack's content
        System.out.println("Stack content: " + stack.toString());

        try {
            System.out.println("\nTop element without removing: " + stack.peek());
            System.out.println("Removing the top element: " + stack.pop());
            System.out.println("Removing the top element: " + stack.pop());
            System.out.println("Removing the top element: " + stack.pop());
            System.out.println("\nRemoving one more element...");
            // This line will cause an exception because the stack is empty
            System.out.println("Top element: " + stack.pop());
        } catch (EmptyCollectionException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}


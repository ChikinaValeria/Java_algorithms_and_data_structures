import LinkedStack.LinkedStack;
import LinkedStack.exceptions.EmptyCollectionException;

public class Main
{
    public static void main(String[] args)
    {
        LinkedStack<String> stack = new LinkedStack<String>();

        System.out.println("LinkedStack class services:");

        System.out.println("\nEmpty Stack");
        System.out.println("The stack is empty: " + stack.isEmpty());
        System.out.println("Stack size is: " + stack.size());
        System.out.println("Content: " + stack);

        System.out.println("\nAdding Elements");
        stack.push("Red");
        System.out.println("Added: Red");
        stack.push("Orange");
        System.out.println("Added: Orange");
        stack.push("Yellow");
        System.out.println("Added: Yellow");

        System.out.println("\nStack with three elements");
        System.out.println("The stack is empty: " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Content: " + stack);

        try {
            System.out.println("\nPeek the Top Element");
            System.out.println("Top element: " + stack.peek());
            System.out.println("Size after peek: " + stack.size());
        } catch (EmptyCollectionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("\nPopping elements");
            String poppedElement = stack.pop();
            System.out.println("Popped element: " + poppedElement);
            System.out.println("Size after pop: " + stack.size());
            System.out.println("Content: " + stack);

            poppedElement = stack.pop();
            System.out.println("Popped element: " + poppedElement);
            System.out.println("Size after pop: " + stack.size());
            System.out.println("Contents: " + stack);
        } catch (EmptyCollectionException e) {
            System.out.println("Error during pop: " + e.getMessage());
        }

        // Getting exception
        System.out.println("\nEmptyCollectionException");
        try {
            System.out.println("Removing last element: " + stack.pop());
            System.out.println("The stack is empty: " + stack.isEmpty());
            System.out.println("Stack size: " + stack.size());

            System.out.println("\nTrying to pop() on an empty stack");
            stack.pop();
        } catch (EmptyCollectionException e) {
            System.err.println("\nCaught expected exception!");
            System.err.println("Error message: " + e.getMessage());
        }
    }
}

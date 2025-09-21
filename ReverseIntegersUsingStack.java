import java.util.Stack;
import java.util.Scanner;

public class ReverseIntegersUsingStack {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Enter five integers separated by spaces and in the end feed <enter>:");
        
        String inputLine = scanner.nextLine();
        String[] numbersAsString = inputLine.split(" ");
        
        if (numbersAsString.length != 5) {
            System.out.println("Error: You should enter five integers.");
            scanner.close();
            return;
        }

        for (String s : numbersAsString) {
            try {
                int number = Integer.parseInt(s);
                stack.push(number);
            } catch (NumberFormatException e) {
                System.out.println("Error: One of the inputs was not a valid integer. Please try again.");
                scanner.close();
                return;
            }
        }

        System.out.println("\nReversed order:");
        
         while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println(); 

        scanner.close();
    }
}

import java.util.Stack;
import java.util.Scanner;

public class ReverseIntegersUsingStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        boolean inputIsValid = false;

        while (!inputIsValid) {
            System.out.println("Enter integers separated by spaces and in the end feed <enter>:");
            String inputLine = scanner.nextLine();
            String[] numbersAsString = inputLine.split(" ");
            
            if (inputLine.trim().isEmpty()) {
                System.out.println("Error: Input cannot be empty. Please try again.");
                continue;// restartung the cycle
            }

            try {
                for (String s : numbersAsString) {
                    int number = Integer.parseInt(s);
                    stack.push(number);
                }
                inputIsValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: One of the inputs was not a valid integer. Please try again.");
                stack.clear();
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


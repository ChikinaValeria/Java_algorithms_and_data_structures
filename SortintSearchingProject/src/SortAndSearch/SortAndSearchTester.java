package SortAndSearch;

import java.util.Scanner;

public class SortAndSearchTester {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (!choice.equalsIgnoreCase("q")) {
            displayMenu();

            choice = scanner.nextLine().trim();

            processChoice(choice);
            System.out.println();
        }

        System.out.println("Program terminated. Goodbye!");
        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("Menu of Searching and Sorting Testbed.");
        System.out.println();
        System.out.println("1)  Linear searching");
        System.out.println("2)  Binary searching");
        System.out.println("3)  O(n^2) type of sorting");
        System.out.println("4)  O(n*log(n)) type of searching");
        System.out.println("5)  Sorting performance");
        System.out.println();
        System.out.println("(q/Q) Quit");
        System.out.println();
        System.out.print("Your choice: ");
    }

    public static void processChoice(String choiceStr) {
        switch (choiceStr.toLowerCase()) {
            case "1":
                System.out.println("Selected Option 1: 1) Linear searching.");
                System.out.println("This section is not implemented yet.");
                // Function call for option 1 will go here
                break;
            case "2":
                System.out.println("This section is not implemented yet.");
                break;
            case "3":
                System.out.println("This section is not implemented yet.");
                break;
            case "4":
                System.out.println("This section is not implemented yet.");
                break;
            case "5":
                System.out.println("This section is not implemented yet.");
                break;
            case "q":
                break;
            default:
                System.out.println("Error: Unknown option. Please enter a number from 1 to 5 or 'Q'.");
                break;
        }
    }
}

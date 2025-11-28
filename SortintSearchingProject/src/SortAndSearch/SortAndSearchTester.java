package SortAndSearch;

import java.util.Scanner;
import java.util.InputMismatchException;

public class SortAndSearchTester {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (!choice.equalsIgnoreCase("q")) {
            displayMenu();

            choice = scanner.nextLine().trim();

            processChoice(choice, scanner);
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

    public static void processChoice(String choiceStr, Scanner scanner) {
        switch (choiceStr.toLowerCase()) {
            case "1":
                handleLinearSearch(scanner);
                break;
            case "2":
                handleBinarySearch(scanner);;
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

    private static void handleLinearSearch(Scanner scanner) {
        System.out.print("In the list are values 0, ..., 9; which value would you like to search with linear search? ");

        try {
            int target = scanner.nextInt();
            String result = LinearSearch.search(target);
            System.out.println(result);

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter an integer value.");
        } finally {
            scanner.nextLine();
        }
    }

    private static void handleBinarySearch(Scanner scanner) {
        System.out.print("In the list are values 0, ..., 9; which value would you like to search with binary search? ");

        try {
            int target = scanner.nextInt();
            // Вызов метода search из рекурсивного класса BinarySearch
            String result = BinarySearch.search(target);
            System.out.println(result);

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter an integer value.");
        } finally {
            // Очистка буфера сканера после nextInt()
            scanner.nextLine();
        }
    }
}

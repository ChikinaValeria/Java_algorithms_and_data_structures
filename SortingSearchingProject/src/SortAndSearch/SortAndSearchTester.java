package SortAndSearch;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Arrays;

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
                handleBubbleSort();
                break;
            case "4":
                handleMergeSort();
                break;
            case "5":
                handleSortingPerformance();
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
            String result = BinarySearch.search(target);
            System.out.println(result);

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter an integer value.");
        } finally {
            scanner.nextLine();
        }
    }

    private static int[] generateRandomIntArray(int size, int maxBound) {
        Random rand = new Random();
        int[] data = new int[size];

        // This sets up the range. If maxBound is 100, we get numbers from -50 to 49
        // We subtract the 'offset' (half of maxBound) to shift the range into negative values
        // If maxBound is 100, the offset is 50
        int offset = maxBound / 2;

        for (int i = 0; i < size; i++) {
            // rand.nextInt(maxBound) creates a number from 0 up to (maxBound - 1)
            // Subtracting the offset shifts the range to include negative numbers
            data[i] = rand.nextInt(maxBound) - offset;
        }
        return data;
    }

    /*private static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            if (i < data.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
*/
    private static void handleBubbleSort() {
        int[] data = generateRandomIntArray(10, 200);
        //int[] dataSelection = Arrays.copyOf(data, data.length);

        System.out.println();
        System.out.println("Data set before bubble sorting:");
        printArray(data);
        System.out.println();

        BubbleSort.sort(data);

        System.out.println("Data set after bubble sorting:");
        printArray(data);

        // Selection Sort Test
        /*
        System.out.println();
        System.out.println("!!!Selection Sort!!!");
        System.out.println("Original data for selection sorting:");
        printArray(dataSelection);
        SelectionSort.sort(dataSelection);
        System.out.println("Data set after selection sorting:");
        printArray(dataSelection);*/
    }

    private static void handleMergeSort() {
        int[] data = generateRandomIntArray(10, 200);
        //int[] dataQuick = Arrays.copyOf(data, data.length);


        System.out.println();
        System.out.println("Data set before merge sorting:");
        printArray(data);
        System.out.println();

        MergeSort.sort(data);

        System.out.println("Data set after merge sorting:");
        printArray(data);

        // Quick Sort Test
        /*System.out.println();
        System.out.println("!!!Quick Sort!!!");
        System.out.println("Original data for quick sorting:");
        printArray(dataQuick);
        QuickSort.sort(dataQuick);
        System.out.println("Data set after quick sorting:");
        printArray(dataQuick);*/
    }

    /**
     * Generates a random array of CountedInts.
     * Note: This method must be static to be used by the static main method.
     */
    private static CountedInt[] generateRandomCountedIntArray(int size, int maxBound) {
        Random rand = new Random();
        CountedInt[] data = new CountedInt[size];
        int offset = maxBound / 2;

        for (int i = 0; i < size; i++) {
            data[i] = new CountedInt(rand.nextInt(maxBound) - offset);
        }
        return data;
    }

    /**
     * Helper to clone a CountedInt array
     */
    private static CountedInt[] cloneArray(CountedInt[] original) {
        CountedInt[] clone = new CountedInt[original.length];
        // We need a deep copy of the objects themselves, not just the references
        for (int i = 0; i < original.length; i++) {
            clone[i] = new CountedInt(original[i].getValue());
        }
        return clone;
    }

    // You may also want to update your old printArray to handle CountedInt (optional, but cleaner)
    private static void printArray(CountedInt[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i].getValue());
            if (i < data.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // Overload for the old method that uses int[]
    private static void printArray(int[] data) {
        // existing implementation remains
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            if (i < data.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private static void handleSortingPerformance() {
        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000};
        int maxBound = 100000; // Large range for variety

        System.out.println("Size, Algorithm, Order, Metric, Value");

        for (int size : sizes) {
            // 1. Generate the initial random data set
            CountedInt[] originalData = generateRandomCountedIntArray(size, maxBound);

            // 2. Test Bubble Sort
            testSortAlgorithm(size, "BubbleSort", originalData, (arr) -> BubbleSort.sort(arr));

            // 3. Test Selection Sort
            testSortAlgorithm(size, "SelectionSort", originalData, (arr) -> SelectionSort.sort(arr));

            // 4. Test Merge Sort
            testSortAlgorithm(size, "MergeSort", originalData, (arr) -> MergeSort.sort(arr));

            // 5. Test Quick Sort
            testSortAlgorithm(size, "QuickSort", originalData, (arr) -> QuickSort.sort(arr));
        }
    }

    /**
     * A functional interface for a sorting method that takes a CountedInt array.
     */
    @FunctionalInterface
    interface SortMethod {
        void sort(CountedInt[] data);
    }

    /**
     * Executes the sorting, monitors time and comparisons, and prints the results.
     */
    private static void testSortAlgorithm(int size, String algoName, CountedInt[] originalData, SortMethod sortFunc) {
        // Deep clone the original array to ensure each sort starts with the same data
        CountedInt[] data = cloneArray(originalData);

        // Reset the counter before starting the sort
        CountedInt.resetCounter();

        // Record start time using System.nanoTime() for high precision
        long startTime = System.nanoTime();

        // Execute the sort function
        sortFunc.sort(data);

        // Record end time and calculate elapsed milliseconds
        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;

        // Get the total comparison count
        long comparisons = CountedInt.getComparisonCount();

        // Print results in the requested format
        // Example: 1000, BubbleSort, random, comparisons, 990000
        System.out.printf("%d, %s, random, comparisons, %d%n", size, algoName, comparisons);
        // Example: 1000, BubbleSort, random, ms, 23
        System.out.printf("%d, %s, random, ms, %d%n", size, algoName, durationMs);
    }
}

package SortAndSearch;

public class BubbleSort {

    public static void sort(int[] data) {
        int n = data.length;
        // The outer loop handles the passes through the array
        for (int i = 0; i < n - 1; i++) {
            // The inner loop performs comparisons and swaps
            // (n - 1 - i) - this part of the array is already sorted
            for (int j = 0; j < n - 1 - i; j++) {
                // If the current element is greater than the next, swap them
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}
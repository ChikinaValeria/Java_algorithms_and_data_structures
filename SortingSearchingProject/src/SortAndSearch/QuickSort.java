package SortAndSearch;

public class QuickSort {

    /**
     * Sorts the array using the Quick Sort algorithm.
     * Average Time Complexity: O(n log n)
     * @param data The array of integers to be sorted.
     */
    public static void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private static void quickSort(int[] data, int low, int high) {
        if (low < high) {
            // partitionIndex is the index of the pivot element after partition
            int partitionIndex = partition(data, low, high);

            // Recursively sort elements before and after partition
            quickSort(data, low, partitionIndex - 1);
            quickSort(data, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] data, int low, int high) {
        // Choose the rightmost element as the pivot
        int pivot = data[high];

        // Index of smaller element
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (data[j] <= pivot) {
                i++;

                // Swap data[i] and data[j]
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        // Swap data[i+1] (the element right after the smaller elements) and data[high] (the pivot)
        int temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;

        return i + 1; // Return the pivot's new position
    }
}
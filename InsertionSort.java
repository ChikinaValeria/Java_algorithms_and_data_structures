import java.util.Random;

public class InsertionSort {
    void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        Random random = new Random();
        int arraySize = 1000;
        int[] arr = new int[arraySize];

        for (int i = 0; i < arraySize; i++){
            arr[i] = random.nextInt(100) - 50; 
        }

        InsertionSort ob = new InsertionSort();

        System.out.print("Original array: ");
        printArray(arr);

        ob.sort(arr);

        System.out.print("Sorted array: ");
        printArray(arr);
    }
}
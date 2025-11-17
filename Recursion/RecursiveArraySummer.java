package Recursion;

public class RecursiveArraySummer {
    public static int calculateSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return recursiveArraySum(arr, 0);
    }

    private static int recursiveArraySum(int[] arr, int currentIndex) {
        if (currentIndex == arr.length) {
            return 0;
        }

        return arr[currentIndex] + recursiveArraySum(arr, currentIndex + 1);
    }

    public static void main(String[] args) {
        int[] numbers = {8, 13, 26, 51};
        int result = calculateSum(numbers);
        System.out.println("The sum of the elements is: " + result);

        int[] emptyArray = {};
        System.out.println("The sum of the empty array is: " + calculateSum(emptyArray));
    }

}

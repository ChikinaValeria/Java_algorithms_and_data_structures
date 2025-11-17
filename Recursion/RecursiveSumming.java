package Recursion;

public class RecursiveSumming {

    public static int sum(int n) {
        if (n < 1) {
            return 0;
        }
        return sumRange(1, n);
    }

    private static int sumRange(int start, int end) {

        if (start == end) {
            return start;
        }

        if (start > end) {
            return 0;
        }

        int mid = (start + end) / 2;
        return sumRange(start, mid) + sumRange(mid + 1, end);
    }

    public static void main(String[] args) {
        int N = 7;
        int result = sum(N);
        System.out.println("The sum of integers from 1 to " + N + " is: " + result);

        N = 1000;
        result = sum(N);
        System.out.println("The sum of integers from 1 to " + N + " is: " + result);
    }
}

package SortAndSearch;

public class BinarySearch {
    private static final int[] SEARCH_LIST = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static String search(int targetValue) {
        boolean found = recursiveSearch(SEARCH_LIST, 0, SEARCH_LIST.length - 1, targetValue);

        return found ? "Found" : "Not found";
    }

    private static boolean recursiveSearch(int[] data, int min, int max, int target) {

        if (min > max) {
            return false;
        }
        int midpoint = min + (max - min) / 2;
        int midpointValue = data[midpoint];

        if (midpointValue == target) {
            return true;
        }
        else if (midpointValue > target) {
            return recursiveSearch(data, min, midpoint - 1, target);
        }
        else {
            return recursiveSearch(data, midpoint + 1, max, target);
        }
    }
}

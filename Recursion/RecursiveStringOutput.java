package Recursion;

public class RecursiveStringOutput {
    public static void printStringRecursively(String s) {
        if (s.length() == 0) {
            return;
        }
        System.out.print(s.charAt(0));

        printStringRecursively(s.substring(1));
    }

    public static void main(String[] args) {
        String testString = "Programming languages three";
        printStringRecursively(testString);

        System.out.println();
    }
}

package PalindromeChecker;

public class PalindromeTestDriver {

    public static void main(String[] args) {

        // Array of strings to test
        String[] testStrings = {
                "ABBA",
                "Madam, I'm Adam",
                "A man, a plan, a canal: Panama",
                "Hello World",
                "12321"
        };

        System.out.println("Palindrome Checker Test");

        for (String s : testStrings) {
            boolean isPal = PalindromeChecker.isPalindrome(s);

            System.out.print("\"" + s + "\"");

            if (isPal) {
                System.out.println(" is a palindrome.");
            } else {
                System.out.println(" is NOT a palindrome.");
            }
        }
    }
}
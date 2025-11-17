package Recursion;

public class RecursiveStringReverse {
    
    public static String reverseString(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        String original = "Hanna Johnson";
        String reversed = reverseString(original);

        System.out.println("String before reverse: " + original);
        System.out.println("Reversed string: " + reversed);
    }
}

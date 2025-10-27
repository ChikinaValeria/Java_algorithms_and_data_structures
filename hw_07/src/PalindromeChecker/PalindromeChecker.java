package PalindromeChecker;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeChecker {
    public static boolean isPalindrome(String inputString) {

        // Use a stack for reverse order (LIFO) and a queue for forward order (FIFO)
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        String cleanString = inputString.toUpperCase().replaceAll("[^A-Z0-9]", "");

        for (int i = 0; i < cleanString.length(); i++) {
            char ch = cleanString.charAt(i);
            stack.push(ch);
            queue.offer(ch);
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                return false;
            }
        }

        return true;
    }
}
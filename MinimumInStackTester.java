public class MinimumInStackTester {
    public static void main(String[] args) {
        MinimumInStack minStack = new MinimumInStack();
        minStack.push(4);
        minStack.push(2);
        minStack.push(5);
        minStack.push(1);

        System.out.println("Current minimum: " + minStack.getMin()); // Output: 1

        minStack.pop(); // Removes 1
        System.out.println("Current minimum: " + minStack.getMin()); // Output: 2

        minStack.pop(); // Removes 5
        System.out.println("Current minimum: " + minStack.getMin()); // Output: 2
    }
}

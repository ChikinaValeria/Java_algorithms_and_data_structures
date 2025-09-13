public class MinimumInStackTester {
    public static void main(String[] args) {
        MinimumInStack minStack = new MinimumInStack();
        minStack.push(4);
        
        System.out.println("Capacity: " + minStack.mainStack.capacity());
        System.out.println("Size: " + minStack.mainStack.size());

        minStack.push(2);
        minStack.push(5);
        minStack.push(1);
        
        System.out.println("firstElement: " + minStack.mainStack.firstElement());
        System.out.println("Get second element: " + minStack.mainStack.get(2));

        System.out.println("Current minimum: " + minStack.getMin()); // Output: 1

        minStack.pop(); // Removes 1
        System.out.println("Current minimum: " + minStack.getMin()); // Output: 2

        minStack.pop(); // Removes 5
        System.out.println("Current minimum: " + minStack.getMin()); // Output: 2

        System.out.println("Capacity: " + minStack.mainStack.capacity());
        System.out.println("Size: " + minStack.mainStack.size());
        System.out.println("Elements: " + minStack.mainStack.elements());
        System.out.println("firstElement: " + minStack.mainStack.firstElement());
        
        System.out.println(minStack.mainStack.toString());
    }
}

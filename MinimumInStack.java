import java.util.Stack;

public class MinimumInStack {

    protected final Stack<Integer> mainStack;
    protected final Stack<Integer> minStack;

    public MinimumInStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public int pop() {
        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int poppedValue = mainStack.pop();
        if (poppedValue == minStack.peek()) {
            minStack.pop();
        }
        return poppedValue;
    }

    public int top() {
        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return mainStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.peek();
    }

}

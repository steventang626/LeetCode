import javafx.util.Pair;
import java.util.Stack;

public class MinStack {
    private Stack<Pair<Integer, Integer>> stack;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x <= min) min = x;
        stack.push(new Pair<>(x, min));
    }

    public void pop() {
        stack.pop();
        if(stack.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = stack.peek().getValue();
        }
    }

    public int top() {
        return stack.peek().getKey();
    }

    public int getMin() {
        return stack.peek().getValue();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
    }
}



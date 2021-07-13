import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by FanZeQiu on 2021/7/12
 */
public class MinStack {
    private Deque<Integer> minStack;
    private Deque<Integer> stack;

    public MinStack() {
        minStack = new LinkedList<>();
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else if (x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        if (minStack.peek().equals(stack.pop()))
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

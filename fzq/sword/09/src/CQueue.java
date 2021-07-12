import java.util.Stack;

class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.size() != 0) {
            return stack2.pop();
        } else {
            if (stack1.size() == 0)
                return -1;
            else {
                while (stack1.size() > 1) {
                    stack2.push(stack1.pop());
                }
                return stack1.pop();
            }
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
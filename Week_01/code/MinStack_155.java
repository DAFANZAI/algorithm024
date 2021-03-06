import java.util.Stack;

public class MinStack_155 {
    /**
     * 使用辅助栈法
     */
    private Stack<Integer> stack;
    private Stack<Integer> stackMin;
    public MinStack_155() {
        stack = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if(stackMin.isEmpty() || x <= stackMin.peek()) {
            stackMin.push(x);
        }
    }

    public void pop() {
        //注意点：两个Integer对象不能直接用==来判断值是否相等
        if(stack.peek().equals(stackMin.peek())) {
            stackMin.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }

}

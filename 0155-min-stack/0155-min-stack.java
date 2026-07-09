class MinStack {
    private int[] stack;
    private int[] minStack;
    private int top;

    public MinStack() {
        stack = new int[16];
        minStack = new int[16];
        top = -1;
    }

    public void push(int value) {
        top++;
        if (top == stack.length) {
            resize();
        }
        stack[top] = value;
        if (top == 0 || value <= minStack[top - 1]) {
            minStack[top] = value;
        } else {
            minStack[top] = minStack[top - 1];
        }
    }

    public void pop() {
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return minStack[top];
    }

    private void resize() {
        stack = java.util.Arrays.copyOf(stack, stack.length * 2);
        minStack = java.util.Arrays.copyOf(minStack, minStack.length * 2);
    }
}
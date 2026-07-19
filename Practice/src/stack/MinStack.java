package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Min Stack
 * Description: Design a stack that supports `push`, `pop`, `top`, and retrieving the minimum element — all in O(1).
 *
 * Input: `push(-2), push(0), push(-3), getMin(), pop(), top(), getMin()`
 * Output: `getMin() → -3`, `top() → 0`, `getMin() → -2`
 */
public class MinStack {

    public static void main(String[] args) {
        MinStackSolution minStackSolution = new MinStackSolution();
        minStackSolution.push(-2);
        minStackSolution.push(0);;
        minStackSolution.push(-3);
        System.out.println(minStackSolution.getMin());
        System.out.println(minStackSolution.pop());
        System.out.println(minStackSolution.top());
        System.out.println(minStackSolution.getMin());
    }

}

class MinStackSolution {
    Deque<Integer> original;
    Deque<Integer> helper;

    public MinStackSolution() {
        this.original = new ArrayDeque<>();
        this.helper = new ArrayDeque<>();
    }

    public void push(int item) {
        original.push(item);
        if(helper.isEmpty() || item < helper.peek()){
            helper.push(item);
        } else {
            helper.push(helper.peek());
        }
    }

    public int pop() {
        helper.pop();
        return original.pop();
    }

    public int top() {
        return original.peek();
    }

    public int getMin() {
        return helper.peek();
    }
}

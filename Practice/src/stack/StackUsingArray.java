package stack;

import java.util.Stack;

public class StackUsingArray {

    public static void main(String[] args) {
        int[] nums = {5, 45, 32, 65, 1, 98};
        StackUsingArraySolution<Integer> arraySolution = new StackUsingArraySolution<>(10);
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            stack.push(num);
            arraySolution.push(num);
        }

        for (int num : nums) {
            int sNum = stack.pop();
            int aNum = arraySolution.pop();
            System.out.println(sNum == aNum);
        }
    }
}

class StackUsingArraySolution<E> {
    private Object[] elements;
    private int ptr = 0;

    public StackUsingArraySolution(int size) {
        elements = new Object[size];
    }

    public void push(E e) {
        if (ptr == elements.length) throw new RuntimeException("Stack is full");
        elements[ptr++] = e;
    }

    public E pop() {
        if (ptr == 0) throw new RuntimeException("Stack is empty");
        E e = (E) elements[--ptr];
        elements[ptr] = null;
        return e;
    }

    public E peek() {
        if (ptr == 0) throw new RuntimeException("Stack is empty");
        return (E) elements[ptr-1];
    }

    public boolean isEmpty(){
        return ptr == 0;
    }
}


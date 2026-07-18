package implementation;

import java.util.Stack;

public class LearnStack {

    public static void main(String[] args) {

//        Stack<Integer> stack = new Stack<>();
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(13);
        stack.push(21);
        stack.push(90);

        printStack(stack);

        stack.pop();
        stack.push(43);
        stack.push(32);
        printStack(stack);
    }

    private static void printStack(Stack<?> stack) {
        for (Object num : stack){
            System.out.print(num + " <- ");
        }
        System.out.println("END");
    }

    private static void printStack(CustomStack<?> stack) {
        for (Object num : stack){
            System.out.print(num + " <- ");
        }
        System.out.println("END");
    }
}

package implementation;

import java.util.PriorityQueue;
import java.util.Queue;

public class LearnQueue {

    public static void main(String[] args) {

//        Queue<Integer> queue = new PriorityQueue<>();
        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.push(13);
        queue.push(21);
        queue.push(90);

        printStack(queue);

        queue.pop();
        queue.push(43);
        queue.push(32);
        printStack(queue);
    }

    private static void printStack(Queue<?> queue) {
        for (Object num : queue){
            System.out.print(num + " <- ");
        }
        System.out.println("END");
    }

    private static void printStack(CustomQueue<?> queue) {
        for (Object num : queue){
            System.out.print(num + " <- ");
        }
        System.out.println("END");
    }
}

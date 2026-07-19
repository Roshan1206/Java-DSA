package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Reverse a String Using a Stack
 * Description: Reverse a string by pushing every character onto a stack, then popping them all off.
 *
 * Input: `s = "hello"`
 * Output: `"olleh"`
 */
public class ReverseStringUsingStack {

    public static void main(String[] args) {
        String str = "hello";
        String sb = reverseString(str);
        System.out.println(sb);
    }

    static String reverseString(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray()) deque.push(c);
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) sb.append(deque.poll());
        return sb.toString();
    }
}

package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid Parentheses
 * Description: Given a string containing only `()[]{}`, determine if the brackets are balanced and correctly nested.
 *
 * Input: `s = "{[()]}"`
 * Output: `true`
 *
 * Input: `s = "{[(])}"`
 * Output: `false`
 */
public class ValidParantheses {

    public static void main(String[] args) {
        System.out.println(isValid("{[()]}"));
        System.out.println(isValid("{[(])}"));
        System.out.println(isValid("(])"));
    }

    static boolean isValid(String str) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');

        Deque<Character> deque = new ArrayDeque<>();
        for(char c : str.toCharArray()){
            if(!deque.isEmpty() && pairs.containsKey(c)) {
                if(pairs.get(c) == deque.peek()){
                    deque.poll();
                } else {
                    return false;
                }
            } else {
                deque.push(c);
            }
        }
        return deque.isEmpty();
    }
}

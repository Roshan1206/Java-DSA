package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *Description: Repeatedly remove pairs of adjacent equal characters until none remain.
 *
 *Input: `s = "abbaca"`
 *Output: `"ca"`
 */
public class RemoveAllAdjacentDuplicates {

    public static void main(String[] args) {
        System.out.println(removeAdjacent("abbaca"));
    }

    static String removeAdjacent(String str) {
        Deque<Character> characters = new ArrayDeque<>();
        for(char c : str.toCharArray()) {
            if(!characters.isEmpty() && c == characters.peek()) {
                characters.pop();
            } else {
                characters.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!characters.isEmpty()) sb.append(characters.pop());

        return sb.reverse().toString();
    }
}

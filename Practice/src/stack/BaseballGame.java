package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Baseball Game (Score Tracking)
 * Description: Given a list of operations (`"+"`, `"D"`, `"C"`, or an integer as string), simulate a score-keeping game: `"+"` sums the last two scores, `"D"` doubles the last score, `"C"` cancels/removes the last score. Return the sum of all remaining scores.
 *
 * Input: `ops = ["5","2","C","D","+"]`
 * Output: `30`
 */
public class BaseballGame {

    public static void main(String[] args) {
        String[] scores = {"5","2","C","D","+"};
        System.out.println(calculateScore(scores));
    }

    static int calculateScore(String[] strings) {
        Deque<Integer> scores = new ArrayDeque<>();

        for(String str : strings) {
            switch(str) {
                case "C" -> scores.pop();
                case "D" -> scores.push(scores.peek() * 2);
                case "+" -> {
                    int lastScore = scores.pop();
                    int newScore = lastScore + scores.peek();
                    scores.push(lastScore);
                    scores.push(newScore);
                }
                default -> scores.push(Integer.parseInt(str));
            }
        }

        int totalScore = 0;
        while(!scores.isEmpty()) totalScore += scores.pop();

        return totalScore;
    }
}

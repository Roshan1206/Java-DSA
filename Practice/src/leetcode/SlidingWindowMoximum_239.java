package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMoximum_239 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
    }

    private static int[] maxSlidingWindow(int[] nums, int k){
        int[] res = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i < nums.length; i++){
            if(!dq.isEmpty() && dq.peekFirst() < i-k+1)
                dq.pollFirst();

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();

            dq.offerLast(i);
            if(i >= k-1)
                res[i-k+1] = nums[dq.peekFirst()];
        }
        return res;
    }
}

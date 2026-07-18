package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link https://leetcode.com/problems/contains-duplicate/description/}
 *
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */
public class ContainsDuplicate_217 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(optimized(nums));
    }

    /**
     * brute force. Iterate through array.
     * for every element, run another iteration and check whether that element is present anywhere else
     */
    public static boolean bruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    /**
     * Optimized
     * Create a set. Set contains unique elements only.
     * Iterate through array and check whether that set contains that element or not
     * If set contains than it is a duplicate and return true
     * If set doesn't contains than add that element in the set and continue the loop
     */
    public static boolean optimized(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}

package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link https://leetcode.com/problems/two-sum/description/}
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSum_1 {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(approach1(nums, target)));
    }

    /**
     * brute force.
     * iterate through array. pick one element, check with every other element
     */
    public static int[] approach1(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Two pointer
     * Sort the array.
     * iterate and check first and last element
     * if target found, return
     * if sum is greater than target, increment start else decrement end
     */
    public static int[] approach2(int[] arr, int target){
        Arrays.sort(arr);
        int start = 0, end = arr.length-1;
        while (start < end){
            if (arr[start]+arr[end]==target)
                return new int[]{start, end};
            if (arr[start] + arr[end] < target)
                start++;
            else
                end--;
        }
        return new int[]{-1, -1};
    }

    /**
     * iterate and add every element in hash map
     * check if the comp is present in map or not
     */
    public static int[] approach3(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int comp = target - arr[i];
            if (map.containsKey(comp)){
                return new int[]{map.get(comp), i};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Iterate through array.
     * Check if comp is present, return or else add that value
     */
    public static int[] approach4(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< arr.length; i++){
            int comp = target - arr[i];
            if (map.containsKey(comp)){
                return new int[]{map.get(comp), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
}

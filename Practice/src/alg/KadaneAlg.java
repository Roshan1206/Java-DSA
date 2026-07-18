package alg;

/**
 * Kadane's Algorithm is used for finding max sum in a continuous subarray from a given array.
 *
 * We use two counters
 * 1. For adding sum i.e. currentSum
 * 2. For max sum i.e. maxSum
 *
 * If at any given index, currentSum is less than 0 than we will reset the currentSum = 0
 * If at any given index, currentSum is greater than maxSum, than we will change maxSum
 */
public class KadaneAlg {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] res = getIndexOfMaxSum(arr);
        System.out.println("Max sum in array: " + getMaxSum(arr) + ". Start: " + res[0] + ", End: " + res[1]);
    }

    private static int getMaxSum(int[] arr) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE; //Initialized the lowest value an int can have.

        for (int i : arr) {
//            adding current value in current sum
            currentSum = currentSum + i;

//            If current sum is less than 0, reset currentSum. no need to carry negative sum
            if (currentSum < 0){
                currentSum = 0;
            }

//            If currentSum is greater than maxSum, change maxSum to currentSum
            if (currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    private static int[] getIndexOfMaxSum(int[] arr){
        int currentSum = 0, maxSum = Integer.MIN_VALUE;
        int start = 0, end = 0, temp = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];

            if (currentSum < 0){
                currentSum = 0;
//                start new index
                temp = i + 1;
            }

            if (currentSum > maxSum){
                maxSum = currentSum;
//                assign new indexes
                start = temp;
                end = i;
            }
        }
        return new int[]{start, end};
    }
}

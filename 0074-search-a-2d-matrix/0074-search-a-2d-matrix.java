class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] nums: matrix){
            if(search(nums, target)){
                return true;
            }
        }
        return false;
    }

    private boolean search(int[] nums, int target){
        int start = 0, end = nums.length-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] == target){
                return true;
            }

            if(nums[mid] > target){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return false;
    }
}
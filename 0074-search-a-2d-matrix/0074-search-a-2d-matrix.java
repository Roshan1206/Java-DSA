class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int start=0, end = rows*cols-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int r = mid/cols;
            int c = mid%cols;
            int midValue = matrix[r][c];

            if(midValue == target){
                return true;
            }

            if(midValue > target){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return false;
    }
}
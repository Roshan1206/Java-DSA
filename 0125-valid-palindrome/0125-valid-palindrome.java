class Solution {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").toCharArray();
        int left=0, right=charArray.length-1;

        while(left<right){
            if(charArray[left] != charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int slow=0, fast=0, maxF=0;
        int res=0;

        while(fast<s.length()){
            counts[s.charAt(fast) - 'A']++;
            maxF = Math.max(maxF, counts[s.charAt(fast) - 'A']);

            if((fast-slow+1)-maxF > k){
                counts[s.charAt(slow) -'A']--;
                slow++;
            }
            res = Math.max(res, fast-slow+1);
            fast++;
        }
        return res;
    }
}
class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();
        int slow=0, fast=0, maxF=0;
        int res=0;

        while(fast<s.length()){
            counts.put(s.charAt(fast), counts.getOrDefault(s.charAt(fast), 0) + 1);
            maxF = Math.max(maxF, counts.get(s.charAt(fast)));

            while((fast-slow+1)-maxF > k){
                counts.put(s.charAt(slow), counts.get(s.charAt(slow))-1);
                slow++;
            }
            res = Math.max(res, fast-slow+1);
            fast++;
        }
        return res;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int slow=0, fast=0;
        int res=0;

        while(fast<s.length()){
            // if(seen.contains(s.charAt(fast))){
                while(seen.contains(s.charAt(fast))){
                    seen.remove(s.charAt(slow));
                    slow++;
                }
            // }
            seen.add(s.charAt(fast));
            res = Math.max(res, seen.size());
            fast++;
        }
        return res;
    }
}
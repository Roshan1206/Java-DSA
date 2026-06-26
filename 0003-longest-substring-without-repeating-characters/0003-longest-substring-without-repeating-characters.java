class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Set<Character> seen = new HashSet<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        int slow=0, fast=0;
        int res=0;

        // while(fast<s.length()){
        //         while(seen.contains(s.charAt(fast))){
        //             seen.remove(s.charAt(slow));
        //             slow++;
        //         }
        //     seen.add(s.charAt(fast));
        //     res = Math.max(res, seen.size());
        //     fast++;
        // }

        while(fast < s.length()){
            char c = s.charAt(fast);
            while(lastIndex.containsKey(c) && lastIndex.get(c) >= slow){
                slow = lastIndex.get(c) + 1;
            }
            lastIndex.put(c, fast);
            res = Math.max(res, fast-slow+1);
            fast++;
        }
        return res;
    }
}
class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";

        Map<Character, Integer> tCounts = new HashMap<>();
        for(char c : t.toCharArray()){
            tCounts.put(c, tCounts.getOrDefault(c, 0)+1);
        }

        int start = 0, end = 0, have = 0, resLen = Integer.MAX_VALUE;
        int[] res = new int[2];
        Map<Character, Integer> sCounts = new HashMap<>();

        while(end < s.length()){
            char ch = s.charAt(end);
            sCounts.put(ch, sCounts.getOrDefault(ch, 0) + 1);
            if(tCounts.containsKey(ch) && sCounts.get(ch).equals(tCounts.get(ch))){
                have++;
            }

            while(have == tCounts.size()){
                if((end-start+1) < resLen){
                        res[0] = start;
                        res[1] = end;
                        resLen = end-start+1;
                    }
                char leftChar = s.charAt(start);
                sCounts.put(leftChar, sCounts.get(leftChar)-1);
                if (tCounts.containsKey(leftChar) && sCounts.get(leftChar) < tCounts.get(leftChar)) {
                    have--;
                }
                start++;
            }
            end++;
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);
    }
}
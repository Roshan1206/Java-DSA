class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> numSet = new HashSet<>();

        for(int num: nums){
            numSet.add(num);
        }

        for(int num : numSet){
            int streak = 0;
            int currentNum = num;

            if(!numSet.contains(currentNum-1)){
                while(numSet.contains(currentNum)){
                    currentNum++;
                    streak++;
                }
            }
            longest = Math.max(longest, streak);
        }
        return longest;
    }
}
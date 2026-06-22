class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<int[]> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        list.sort((a,b) -> b[1]-a[1]);

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = list.get(i)[0];
        }
        return res;
    }
}
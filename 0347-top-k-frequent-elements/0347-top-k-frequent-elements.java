class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        // List<int[]> list = new ArrayList<>();
        // for(Map.Entry<Integer, Integer> entry:map.entrySet()){
        //     list.add(new int[]{entry.getValue(), entry.getKey()});
        // }
        // list.sort((a,b) -> b[0]-a[0]);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            // res[i] = list.get(i)[1];
            res[i] = queue.poll()[1];
        }
        return res;
    }
}
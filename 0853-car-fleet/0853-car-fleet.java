class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for(int i=0;i<n;i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target-position[i])/speed[i];
        }        

        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0]));
        Deque<Double> stack = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            double currTime = cars[i][1];
            if(stack.isEmpty() || currTime > stack.peek()){
                stack.push(currTime);
            }
        }
        return stack.size();
    }
}
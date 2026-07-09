class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();

        for(String s : tokens){
            switch(s){
                case "+", "-", "*", "/" -> {
                    int second = nums.pop();
                    int first = nums.pop();

                    switch(s){
                        case "+" -> nums.push(first+second);
                        case "-" -> nums.push(first-second);
                        case "*" -> nums.push(first*second);
                        case "/" -> nums.push(first/second);
                    }
                }
                default -> nums.push(Integer.parseInt(s));
            }
        }
        return nums.pop();
    }
}
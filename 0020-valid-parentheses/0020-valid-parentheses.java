class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        Deque<Character> parentheses = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(c==')' || c==']' || c=='}'){
                if(!parentheses.isEmpty() && parentheses.peek() == pairs.get(c)){
                    parentheses.pop();
                } else {
                    return false;
                }
            } else {
                parentheses.push(c);
            }
        }
        return parentheses.isEmpty();
    }
}
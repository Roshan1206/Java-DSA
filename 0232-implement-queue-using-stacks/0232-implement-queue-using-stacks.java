class MyQueue {
    Stack<Integer> primary = new Stack<>();
    Stack<Integer> secondary = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        primary.push(x);
    }
    
    public int pop() {
        while(!empty()){
            secondary.push(primary.pop());
        }

        int element = secondary.pop();

        while(!secondary.isEmpty()){
            primary.push(secondary.pop());
        }
        return element;
    }
    
    public int peek() {
        while(!empty()){
            secondary.push(primary.pop());
        }

        int element = secondary.peek();

        while(!secondary.isEmpty()){
            primary.push(secondary.pop());
        }
        return element;
    }
    
    public boolean empty() {
        return primary.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyQueue {

    private int[] arr;
    private final static int DEFAULT_SIZE = 10;
    int ptr = 0;
    public MyQueue() {
        arr = new int[DEFAULT_SIZE];
    }
    
    public void push(int x) {
        if(ptr == arr.length){
            int[] temp = new int[arr.length*2];
            for(int i=0; i<arr.length; i++){
                temp[i] = arr[i];
            }
            arr = temp;
        }
        arr[ptr++] = x;
    }
    
    public int pop() {
        int el = arr[0];
        for(int i=1; i<arr.length; i++){
            arr[i-1] = arr[i];
        }
        ptr--;
        return el;
    }
    
    public int peek() {
        return arr[0];
    }
    
    public boolean empty() {
        return ptr == 0;
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
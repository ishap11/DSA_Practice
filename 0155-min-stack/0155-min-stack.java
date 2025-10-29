class MinStack {

    Stack<Integer> ms;
    Stack<Integer> minS;

    public MinStack() {
        ms = new Stack<>();
        minS = new Stack<>();
    }
    
    public void push(int val) {
        ms.push(val);

        if(minS.isEmpty() || val <= minS.peek()){
            minS.push(val);
        }
    }
    
    public void pop() {
        int top = ms.pop();
        if(top == minS.peek()) {
            minS.pop();
        }
        
    }
    
    public int top() {
        return ms.peek();
    }
    
    public int getMin() {
        return minS.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
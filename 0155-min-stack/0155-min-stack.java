class MinStack {
    Stack<Integer> st;
    Stack<Integer> hst;

    public MinStack() {
        st = new Stack<>();
        hst = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
    }
    
    public void pop() {
        int rem = st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        int minElem = Integer.MAX_VALUE;

        while(!st.isEmpty()) {
            if(st.peek() < minElem) {
                minElem = st.peek();
            }
            hst.push(st.pop());
        }

        while (!hst.isEmpty()) {
            st.push(hst.pop());
        }

        return minElem;
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
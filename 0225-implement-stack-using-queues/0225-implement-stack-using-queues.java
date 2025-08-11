class MyStack {

    Queue<Integer> mq;
    Queue<Integer> cq;

    public MyStack() {
        mq = new ArrayDeque<>();
        cq = new ArrayDeque<>();
    }
    
    public void push(int x) {
        mq.add(x);
    }
    
    public int pop() {
        while(mq.size() > 1) {
            cq.add(mq.remove());
        }

        int rem = mq.remove();

        while(cq.size() > 0) {
            mq.add(cq.remove());
        }

        return rem;
    }
    
    public int top() {
        while(mq.size() > 1) {
            cq.add(mq.remove());
        }

        int rem = mq.remove();
        cq.add(rem);

        while(cq.size() > 0) {
            mq.add(cq.remove());
        }

        return rem;
    }
    
    public boolean empty() {
        return mq.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
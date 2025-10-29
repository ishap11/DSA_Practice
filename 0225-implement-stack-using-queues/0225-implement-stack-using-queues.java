class MyStack {
    Queue<Integer> que1;
    Queue<Integer> que2;

    public MyStack() {
        que1 = new ArrayDeque<>();
        que2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        que1.add(x);
    }
    
    public int pop() {
        while(que1.size() > 1){
            que2.add(que1.remove());
        }
        int popElem = que1.remove();
        while(!que2.isEmpty()){
            que1.add(que2.remove());
        }

        return popElem;
    }
    
    public int top() {
        while(que1.size() > 1){
            que2.add(que1.remove());
        }
        int topElem = que1.remove();
        que2.add(topElem);

        while(!que2.isEmpty()){
            que1.add(que2.remove());
        }

        return topElem;
    }
    
    public boolean empty() {
        return que1.isEmpty();
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
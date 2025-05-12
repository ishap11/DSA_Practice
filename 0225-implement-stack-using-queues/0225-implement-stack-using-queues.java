class MyStack {
    Queue<Integer> mainQ ;
    Queue<Integer> helperQ;
    public MyStack() {
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }
    
    public void push(int x) {
        mainQ.add(x);
    }
    
    public int pop() {
        int size = mainQ.size();

        while(size > 1) {
            helperQ.add(mainQ.remove());
            size--;
        }
        int popped = mainQ.remove();

        Queue<Integer> temp = mainQ;
        mainQ = helperQ;
        helperQ = temp;

        return popped;
    }
    
    public int top() {
       int size = mainQ.size();

        while(size > 1) {
            helperQ.add(mainQ.remove());
            size--;
        }
        int topelem = mainQ.remove();  // remove last element
        helperQ.add(topelem);          // add it back so it stays in stack

        Queue<Integer> temp = mainQ;
        mainQ = helperQ;
        helperQ = temp;

        return topelem;
    }
    
    public boolean empty() {
        return mainQ.isEmpty() ;
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
class MyQueue {
    Stack<Integer> mainSt;
    Stack<Integer> helperSt;
    public MyQueue() {
        mainSt = new Stack<>();
        helperSt = new Stack<>();
    }
    
    public void push(int x) {
        mainSt.push(x);
    }
    
    public int pop() {
        if (empty()) return -1;

        while (mainSt.size() > 1) {
            helperSt.push(mainSt.pop());
        }
        int front = mainSt.pop();

        while (!helperSt.isEmpty()) {
            mainSt.push(helperSt.pop());
        }

        return front;

    }
    
    public int peek() {
        if (empty()) return -1;

        while (mainSt.size() > 1) {
            helperSt.push(mainSt.pop());
        }
        int topelem = mainSt.peek();
        helperSt.push(mainSt.pop());

        while (!helperSt.isEmpty()) {
            mainSt.push(helperSt.pop());
        }

        return topelem;
    }
    
    public boolean empty() {
        return mainSt.isEmpty();
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
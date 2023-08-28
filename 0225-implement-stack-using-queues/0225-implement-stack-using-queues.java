class MyStack {
    
    private Queue<Integer> primaryQueue;
    private Queue<Integer> secondaryQueue;
    
    public MyStack() {
        primaryQueue = new LinkedList<>();
        secondaryQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        primaryQueue.add(x);
    }
    
    public int pop() {
        while (primaryQueue.size() > 1) {
            secondaryQueue.add(primaryQueue.poll());
        }
        int result = primaryQueue.poll();
        swapQueues();
        return result;
    }
    
    public int top() {
        while (primaryQueue.size() > 1) {
            secondaryQueue.add(primaryQueue.poll());
        }
        int result = primaryQueue.poll();
        secondaryQueue.add(result);
        swapQueues();
        return result;
    }
    
    public boolean empty() {
        return primaryQueue.isEmpty();
    }
    
    private void swapQueues() {
        Queue<Integer> temp = primaryQueue;
        primaryQueue = secondaryQueue;
        secondaryQueue = temp;
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
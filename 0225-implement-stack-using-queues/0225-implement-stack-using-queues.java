class MyStack {
    
    private Queue<Integer> primaryQueue;
    private Queue<Integer> secondaryQueue;
    
     /** Initialize your data structure here. */
    public MyStack() {
        primaryQueue = new LinkedList<>(); // Primary queue for stack operations
        secondaryQueue = new LinkedList<>(); // Secondary queue for temporary storage
    }
    
      /** Push element x onto stack. */
    public void push(int x) {
        primaryQueue.add(x); // Simply add the new element to the primary queue
    }
    
     /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (primaryQueue.size() > 1) {
            secondaryQueue.add(primaryQueue.poll()); // Move elements from primary to       secondary queue except the last one
        }
        int result = primaryQueue.poll();  // The last element in the primary queue is the one to be removed
        swapQueues(); // Swap the primary and secondary queues to maintain the order
        return result;
    }
    
     /** Get the top element. */
    public int top() {
        while (primaryQueue.size() > 1) {
            secondaryQueue.add(primaryQueue.poll()); // Move elements from primary to secondary queue except the last one
        }
        int result = primaryQueue.poll(); // The last element in the primary queue is the top element
        secondaryQueue.add(result); // Add the top element back to the secondary queue
        swapQueues(); // Swap the primary and secondary queues to maintain the order
        return result;
    }
    
      /** Returns whether the stack is empty. */
    public boolean empty() {
        return primaryQueue.isEmpty(); // The stack is empty if the primary queue is empty
    }
    
     /** Swap the two queues. */
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
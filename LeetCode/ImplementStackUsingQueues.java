class MyStack {

    Deque<Integer> queue1 = new LinkedList<>();
    Deque<Integer> queue2 = new LinkedList<>();
    
    public MyStack() {
        
    }
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int res = queue1.poll();
        queue1 = queue2;
        queue2 = new LinkedList<>();
        return res;
    }
    
    public int top() {
        int res = pop();
        queue1.offer(res);
        return res;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
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

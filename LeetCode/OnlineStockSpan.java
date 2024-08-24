class StockSpanner {
    Stack<Integer> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();
    int ind = 0;

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        while (!stack.isEmpty() && list.get(stack.peek()) <= price) {
            stack.pop();
        }
        int highestInd = stack.isEmpty() ? -1 : stack.peek();
        list.add(price);
        stack.push(ind++);
        
        if (highestInd == -1) {
            return list.size();
        }
        return list.size() - highestInd - 1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

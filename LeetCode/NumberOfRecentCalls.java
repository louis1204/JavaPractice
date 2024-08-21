class RecentCounter {
    Deque<Integer> pings = new LinkedList<>();
    int prevSum = 0;
    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        prevSum++;
        int lowerBound = t - 3000;
        while (!pings.isEmpty() && pings.peek() < lowerBound) {
            pings.pop();
            prevSum--;
        }
        pings.add(t);
        return prevSum;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

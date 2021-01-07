class HitCounter {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    /** Initialize your data structure here. */
    public HitCounter() {

    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        while (!minHeap.isEmpty() && minHeap.peek() <= timestamp - (5 * 60)) {
            minHeap.remove();
        }
        minHeap.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!minHeap.isEmpty() && minHeap.peek() <= timestamp - (5 * 60)) {
            minHeap.remove();
        }
        return minHeap.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

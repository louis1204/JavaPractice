class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> lo = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> hi = new PriorityQueue<>();
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        lo.add(num);
        
        hi.add(lo.poll());
        
        if (hi.size() > lo.size()) {
            lo.add(hi.poll());
        }
    }
    
    public double findMedian() {
        if (lo.size() == hi.size()) {
            // System.out.println(lo.peek());
            // System.out.println(hi.peek());
            return (lo.peek() + hi.peek()) / 2.0;
        }
        return lo.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 *//

class MedianFinder {

    List<Integer> list = new ArrayList<>();
    boolean isSorted = false;
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        list.add(num);
        isSorted = false;
    }
    
    public double findMedian() {
        if (!isSorted) {
            list.sort((a, b) -> a - b);
        }
        isSorted = true;
        if (list.size() == 0) {
            return 0;
        } 
        if (list.size() % 2 != 0) {
            return list.get(list.size() / 2);
        } else {
            int mid = list.size() / 2;
            return (list.get(mid) + list.get(mid - 1)) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

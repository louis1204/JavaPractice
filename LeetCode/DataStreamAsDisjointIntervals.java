class SummaryRanges {

    TreeSet<Integer> set = new TreeSet<>((a, b) -> {
        return a - b;
    });

    public SummaryRanges() {
        
    }
    
    public void addNum(int value) {
        set.add(value);
    }
    
    public int[][] getIntervals() {
        List<int[]> intervals = new ArrayList<>();
        for (int curr : set) {
            if (intervals.isEmpty()) {
                intervals.add(new int[] {curr, curr});
                continue;
            }
            int[] last = intervals.get(intervals.size() - 1);
            if (curr - 1 == last[1]) {
                // combine
                last[1] = curr;
            } else {
                intervals.add(new int[] {curr, curr});
            }
        }
        return getArrayCopy(intervals);
    }

    private int[][] getArrayCopy(List<int[]> list) {
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = new int[] {list.get(i)[0], list.get(i)[1]};
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */

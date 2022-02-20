class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // just sort
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int res = 1; // gotta have at least one
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
            
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if (currStart >= prevStart && currEnd <= prevEnd) {
                continue;
            } else {
                res++;
                prevStart = intervals[i][0];
                prevEnd = intervals[i][1];
            }
        }
        return res;
    }
}

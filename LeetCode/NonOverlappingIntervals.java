class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Always pick intervals with the earliest stop interval
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
        int amtToRemove = 0;
        int lastEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // See if the current start is before the last end
            if (intervals[i][0] < lastEnd) {
                amtToRemove++;
            } else {
                lastEnd = intervals[i][1];
            }
        }
        return amtToRemove;
    }
}

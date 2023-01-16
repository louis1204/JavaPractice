class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Look at intervals and find an overlap point
        // If there's no overlap, insert at the end
        // Overlap if new end's is smaller than interval end and greater than interval start
        // new start is greater than interval start and less than interval end
        // start is less than interval start and end is greater than interval end
        List<List<Integer>> res = new ArrayList<>();
        boolean added = false;
        if (intervals.length == 0) {
            res.add(Arrays.asList(newInterval[0], newInterval[1]));
            added = true;
        }
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (!added) {
                System.out.println("Interval: " + Arrays.toString(interval));
                System.out.println("to add: " + Arrays.toString(newInterval));
                if (newInterval[0] <= interval[1] && newInterval[1] >= interval[0] &&
                   newInterval[0] >= interval[0] && newInterval[1] <= interval[1]) {
                    // completely contained
                    res.add(Arrays.asList(interval[0], interval[1]));
                    added = true;
                } else if (newInterval[0] >= interval[0] && newInterval[0] <= interval[1]) {
                    // partial front containment
                    res.add(Arrays.asList(interval[0], Math.max(interval[1], newInterval[1])));
                    added = true;
                } else if (newInterval[1] <= interval[1] && newInterval[1] >= interval[0]) {
                    // partial tail containment
                    res.add(Arrays.asList(Math.min(interval[0], newInterval[0]), interval[1]));
                    added = true;
                } else if (newInterval[0] <= interval[0] && newInterval[1] >= interval[1]) {
                    // complete overlap
                    res.add(Arrays.asList(newInterval[0], newInterval[1]));
                    added = true;
                } else if (newInterval[1] < interval[0]) {
                    // completely less
                    res.add(Arrays.asList(newInterval[0], newInterval[1]));
                    res.add(Arrays.asList(interval[0], interval[1]));
                    added = true;
                } else {
                    res.add(Arrays.asList(interval[0], interval[1]));
                }
            } else {
                List<Integer> prev = res.remove(res.size() - 1);
                if (interval[0] <= prev.get(1)) {
                    prev.set(1, Math.max(prev.get(1), interval[1]));
                    res.add(prev);
                } else {
                    res.add(prev);
                    res.add(Arrays.asList(interval[0], interval[1]));
                }
            }
        }
        if (!added) {
            res.add(Arrays.asList(newInterval[0], newInterval[1]));
        }
        int[][] pRes = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            pRes[i][0] = res.get(i).get(0);
            pRes[i][1] = res.get(i).get(1);
        }
        return pRes;
    }
}

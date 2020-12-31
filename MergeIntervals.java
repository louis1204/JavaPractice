class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<List<Integer>> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (res.isEmpty()) {
                res.add(Arrays.asList(interval[0], interval[1]));
                continue;
            }
            // Check if we can increase the previous interval
            List<Integer> prev = res.get(res.size() - 1);
            if (interval[0] <= prev.get(1) && interval[1] >= prev.get(1)) {
                prev.set(1, interval[1]);
            } else if (interval[0] > prev.get(1)) {
                res.add(Arrays.asList(interval[0], interval[1]));
            }
        }
        int[][] actualRes = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            actualRes[i][0] = res.get(i).get(0);
            actualRes[i][1] = res.get(i).get(1);
        }
        return actualRes;
    }
}

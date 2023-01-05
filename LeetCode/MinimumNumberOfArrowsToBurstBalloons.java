class Solution {
    public int findMinArrowShots(int[][] points) {
        // Greedily find the points with the most amount of
        // overlapping balloons
        // Then remove those balloons until we have no more
        // Shooting balloons in the most overlapped point may
        // remove balloons from other points
        // Sort by start, then by end if they are the same
        // We keep track of the minimumum end seen so far and if the
        // subsequent ballon's start is before that end, it is included
        // in the component
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return 0;
                } else if (a[1] < b[1]) {
                    return -1;
                } else {
                    return 1;
                }
            }
            if (a[0] == b[0]) {
                return 0;
            } else if (a[0] < b[0]) {
                return -1;
            } else {
                return 1;
            }
        });
        int arrows = 1;
        int minEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];
            if (curr[0] > minEnd) {
                arrows++;
                minEnd = curr[1];
            } else {
                minEnd = Math.min(minEnd, curr[1]);
            }
        }
        return arrows;
    }
}

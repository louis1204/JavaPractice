class Solution {
    public long maxPoints(int[][] points) {
        // Go through each row's columns, look at the previous rows columns and calculate the max value it can achieve. Update the cell to that value
        // At the end, return the max of the last row
        // O(m * n * n)
        long res = 0;
        long[][] dp = new long[points.length][points[0].length];
        for (int i = 0; i < points[0].length; i++) {
            dp[0][i] = points[0][i];
            res = Math.max(res, points[0][i]);
        } 
        for (int i = 1; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                // Find the max value for this cell
                long max = max(i, j, dp, points[i][j]);
                dp[i][j] = max;
                res = Math.max(res, max);
            }
        }
        return res;
    }

    private long max(int i, int j, long[][] dp, int curr) {
        long max = 0;
        for (int col = 0; col < dp[i].length; col++) {
            max = Math.max(max, curr + dp[i - 1][col] - (int)Math.abs(col - j));
        }
        return max;
    }
}

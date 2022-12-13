class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[matrix.length][matrix[0].length];
        // we can form a dp matrix from the bottom to the top then just look at what
        // min is in the top row
        // Initialize the bottom row
        for (int i = 0; i < matrix[0].length; i++) {
            dp[m - 1][i] = matrix[m - 1][i];
        }
        for (int row = m - 2; row >= 0; row--) {
            // System.out.println(row);
            for (int i = 0; i < matrix[0].length; i++) {
                int min = Integer.MAX_VALUE;
                if (i > 0) {
                    min = Math.min(min, dp[row + 1][i - 1]);
                }
                min = Math.min(min, dp[row + 1][i]);
                if (i < n - 1) {
                    min = Math.min(min, dp[row + 1][i + 1]);
                }
                dp[row][i] = min + matrix[row][i];
            }
        }
        // for (int[] row : dp) {
        //     System.out.println(Arrays.toString(row));
        // }
        int res = Integer.MAX_VALUE;
        for (int num : dp[0]) {
            res = Math.min(res, num);
        }
        return res;
    }
}

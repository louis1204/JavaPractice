class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int[] squares = new int[n + 1];
        for (int i = 1; i < squares.length; i++) {
            squares[i] = i * i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < squares.length; j++) {
                if (squares[j] > i) {
                    break;
                }
                if (dp[i] == 0) {
                    dp[i] = 1 + dp[i - squares[j]];
                } else {
                    dp[i] = Math.min(dp[i], 1 + dp[i - squares[j]]);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}

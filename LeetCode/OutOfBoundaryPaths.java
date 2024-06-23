class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // Definitely going to need to use DP since the answer can be very large.
        // We can create a matrix that saves the results from each cell, the amount of moves left,
        // and the value will be the amount of ways we can go out of the grid
        // So the dp matrix will be m x n x maxMove
        // We will initiate it with all -1 to represent unexplored cells
        // We start at startRow and startColumn with maxMoves, then we recursively do the following
        // If we're out, return 1
        // if maxMove is 0 return 0
        // Check if the dp contains the result from the maxMove, row, column
        // If yes, return that
        // Otherwise go in all directions and recursively call decrementing max move
        // From all results, add together and modulo 1e7
        // Store the result in the dp matrix
        // return the result
        
        // The complexity is m * n * maxMove
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int[][] inner : dp) {
            for (int[] inner2: inner) {
                Arrays.fill(inner2, -1);
            }
        }
        return helper(dp, startRow, startColumn, maxMove, m, n);
    }

    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int modulo = (int) 1e9 + 7;
    private int helper(int[][][] dp, int startRow, int startColumn, int maxMove, int m, int n) {
        if (maxMove < 0) {
            return 0; // We weren't supposed to be here
        }
        if (startRow < 0 || startColumn < 0 || startRow >= m || startColumn >= n) {
            return 1; // We broke free
        }
        if (maxMove == 0) {
            return 0; // We're within the grid, but we have no moves left, so we can't go out
        }
        if (dp[startRow][startColumn][maxMove] != -1) {
            return dp[startRow][startColumn][maxMove];
        }
        int result = 0;
        for (int[] dir : dirs) {
            int temp = helper(dp, startRow + dir[0], startColumn + dir[1], maxMove - 1, m, n);
            temp %= modulo;
            result += temp;
            result %= modulo;
        }
        dp[startRow][startColumn][maxMove] = result;
        return result;
    }
}

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] map = new int[n][n];
        // Make free space 0's, mines as 1
        for (int[] mine : mines) {
            map[mine[0]][mine[1]] = 1;
        }
        int[][] dp = new int[n][n];
        int res = 0;
        // left to right, top to bottom
        for (int i = 0; i < n; i++) {
            int horizCount = 0;
            for (int j = 0; j < n; j++) {
                horizCount = map[i][j] == 1 ? 0 : horizCount + 1;
                dp[i][j] = horizCount;
            }
            
            horizCount = 0;
            for (int j = n - 1; j >= 0; j--) {
                horizCount = map[i][j] == 1 ? 0 : horizCount + 1;
                dp[i][j] = Math.min(dp[i][j], horizCount);
            }
        }
        // right to left, bottom to top
        for (int j = 0; j < n; j++) {
            int vertCount = 0;
            for (int i = 0; i < n; i++) {
                vertCount = map[i][j] == 1 ? 0 : vertCount + 1;
                dp[i][j] = Math.min(dp[i][j], vertCount);
            }
            
            vertCount = 0;
            for (int i = n - 1; i >= 0; i--) {
                vertCount = map[i][j] == 1 ? 0 : vertCount + 1;
                dp[i][j] = Math.min(dp[i][j], vertCount);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
    
//     private int helper(int i, int j, int dist, int[][] map) {
//         int leftX = j - dist;
//         int rightX = j + dist;
//         int topY = i - dist;
//         int botY = i + dist;
//         if (leftX < 0 || rightX >= n || topY < 0 || botY >= n) {
//             return dist;
//         }
//         if (map[i][leftX] == 1 || map[i][rightX] == 1 || map[topY][j] == 1 || map[botY][j] == 1) {
//             return dist;
//         }
//         return helper(i, j, dist + 1, map);
//     }
}

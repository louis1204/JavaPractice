class Solution {
    public int matrixScore(int[][] grid) {
        // Greedy approach
        // Make each row the biggest it can be, criteria is if the left most is 0 or not
        // Then starting from right to left, flip if we can get more 1's that way
        for (int[] row : grid) {
            if (row[0] == 0) {
                // Flip that shit
                for (int i = 0; i < row.length; i++) {
                    row[i] = row[i] == 0 ? 1 : 0;
                }
            }
        }
        // cols
        for (int i = grid[0].length - 1; i >= 0; i--) {
            int oneCount = 0, zeroCount = 0;
            for (int[] row : grid) {
                if (row[i] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            if (zeroCount > oneCount) {
                // flip
                for (int[] row : grid) {
                    row[i] = row[i] == 0 ? 1 : 0;
                }
            }
        }
        // Get the score
        int score = 0;
        for (int[] row : grid) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 1) {
                    score += (int)Math.pow(2, row.length - i - 1);
                }
            }
        }
        return score;
    }
}

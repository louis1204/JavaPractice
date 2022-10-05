class Solution {
    public int maxSum(int[][] grid) {
        // Create a summation of full 3 element columns and 2 element columns with the middle missing
        int[][][] sums = new int[grid.length][grid[0].length][2]; // row, col, [full, full - mid]
        
        for (int row = 0; row < grid.length - 2; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int full = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
                int noMid = grid[row][col] + grid[row + 2][col];
                sums[row][col][0] = full;
                sums[row][col][1] = noMid;
            }
        }
        int max = 0;
        for (int row = 0; row < grid.length - 2; row++) {
            for (int col = 0; col < grid[0].length - 2; col++) {
                max = Math.max(max, sums[row][col][1] + sums[row][col + 1][0] + sums[row][col + 2][1]);
            }
        }
        return max;
    }
}

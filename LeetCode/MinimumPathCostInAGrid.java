class Solution {
    int[] cache = null;
    
    public int minPathCost(int[][] grid, int[][] moveCost) {
        // Looks like we can simulate starting from every first row of the grid
        // We can cache each value to steps to the end
        cache = new int[grid.length * grid[0].length];
        Arrays.fill(cache, -1);
        
        int min = Integer.MAX_VALUE;
        for (int num : grid[0]) {
            int res = helper(num, 0, grid, moveCost);
            min = Math.min(min, res);
        }
        // System.out.println(Arrays.toString(cache));
        return min;
    }
    
    private int helper(int curr, int row, int[][] grid, int[][] moveCost) {
        // row is at the end
        if (row == grid.length - 1) {
            return curr;
        }
        if (cache[curr] != -1) {
            return cache[curr];
        }
        // Get the min for all next rows
        int min = Integer.MAX_VALUE;
        for (int col = 0; col < grid[0].length; col++) {
            min = Math.min(min, helper(grid[row + 1][col], row + 1, grid, moveCost) + moveCost[curr][col] + curr);
        }
        cache[curr] = min;
        return min;
    }
}

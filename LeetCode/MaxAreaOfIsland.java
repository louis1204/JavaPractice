class Solution {
    boolean[][] seen = null;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    int biggest = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (seen[i][j]) {
                    continue;
                }
                biggest = Math.max(biggest, helper(i, j, grid));
            }
        }
        return biggest;
    }
    
    private int helper(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return 0;
        }
        if (seen[i][j]) {
            return 0;
        }
        seen[i][j] = true;
        
        if (grid[i][j] == 0) {
            return 0;
        }
        int island = 1;
        for (int[] dir : dirs) {
            island += helper(i + dir[0], j + dir[1], grid);
        }
        return island;
    }
} 

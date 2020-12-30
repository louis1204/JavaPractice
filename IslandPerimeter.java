class Solution {
    int[][] dirs = new int[][] {{-1, 0},
                                {0, -1}, {0, 1},
                                {1, 0}};
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    // Land ho
                    return getPerimeter(grid, i, j, new HashSet<>());
                }
            }
        }
        return 0;
    }
    
    private int getPerimeter(int[][] grid, int i, int j, HashSet<Pair<Integer, Integer>> seen) {
        Pair<Integer, Integer> point = new Pair<>(i, j);
        if (seen.contains(point)) {
            // Already explored this land
            return 0;
        }
        if (i < 0 || i >= grid.length
           || j < 0 || j >= grid[i].length) {
            // We're at an edge, treat as water
            return 1;
        }
        if (grid[i][j] == 0) {
            // We're bordering water
            return 1;
        }
        seen.add(point);
        int currPerim = 0;
        for (int[] dir : dirs) {
            currPerim += getPerimeter(grid, i + dir[0], j + dir[1], seen);
        }
        return currPerim;
    }
}

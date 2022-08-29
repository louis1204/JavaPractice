class Solution {
    Set<List<Integer>> visited = new HashSet<>();
    public int numIslands(char[][] grid) {
        // Have a set of List<i, j> that represents visited
        // For each position explore if not yet visited explore as left and bot
        // If we had a 1, update number of islands
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (visited.contains(Arrays.asList(i, j))) {
                    continue;
                }
                boolean isIsland = explore(grid, i, j);
                if (isIsland) {
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    
    private boolean explore(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return false;
        }
        List<Integer> coord = Arrays.asList(i, j);
        if (visited.contains(coord)) {
            return grid[i][j] == '1';
        }
        visited.add(coord);
        if (grid[i][j] == '0') {
            return false;
        }
        boolean left = explore(grid, i, j - 1);
        boolean right = explore(grid, i, j + 1);
        boolean top = explore(grid, i - 1, j);
        boolean bot = explore(grid, i + 1, j);
        return grid[i][j] == '1' || left || right || top || bot;
    }
}

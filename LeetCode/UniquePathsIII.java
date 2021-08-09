class Solution {
    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int ways = 0;
    int amountOfOpen = 0;
    public int uniquePathsIII(int[][] grid) {
        // find the start
        int[] start = new int[]{0, 0};
        int[] end = new int[]{0, 0};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                    amountOfOpen++; // Treat starting as open as well
                }
                if (grid[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                }
                if (grid[i][j] == 0) {
                    amountOfOpen++;
                }
            }
        }
        // System.out.println(Arrays.toString(start));
        // System.out.println(Arrays.toString(end));
        // System.out.println(amountOfOpen);
        helper(grid, start, end, new HashSet<>());
        return ways;
    }
    
    private void helper(int[][] grid, int[] pos, int[] end, HashSet<Pair<Integer, Integer>> seen) {
        int i = pos[0];
        int j = pos[1];
        Pair<Integer, Integer> currPair = new Pair<>(i, j);
        // System.out.println(seen.toString());
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return;
        }
        
        if (seen.contains(currPair) || grid[i][j] == -1) {
            return;
        }
        
        if (i == end[0] && j == end[1]) {
            if (seen.size() == amountOfOpen) {
                ways++;
            }
            return;
        }
        
        seen.add(currPair);
        for (int[] dir : dirs) {
            helper(grid, new int[] { i + dir[0], j + dir[1] }, end, seen);
        }
        seen.remove(currPair);
    }
}

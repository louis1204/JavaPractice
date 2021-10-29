class Solution {
    public int orangesRotting(int[][] grid) {
        // Need to keep track of the fresh oranges
        Set<Pair<Integer, Integer>> fresh = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh.add(new Pair<>(i, j));
                }
            }
        }
        if (fresh.isEmpty()) {
            return 0;
        }
        int minutes = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        while (!fresh.isEmpty()) {
            // System.out.println(fresh.toString());
            Set<Pair<Integer, Integer>> rotten = new HashSet<>();
            for (var f : fresh) {
                for (int[] dir : dirs) {
                    int newM = f.getKey() + dir[0];
                    int newN = f.getValue() + dir[1];
                    if (newM >= 0 && newM < m && newN >= 0 && newN < n) {
                        if (grid[newM][newN] == 2) {
                            rotten.add(f);
                            break;
                        }
                    }
                }
            }
            if (rotten.isEmpty()) {
                return -1;
            }
            for (var rot : rotten) {
                fresh.remove(rot);
                grid[rot.getKey()][rot.getValue()] = 2;
            }
            minutes++;
        }
        return minutes;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        List<Pair<Integer, Integer>> bfs = new ArrayList<>();
        bfs.add(new Pair<>(0, 0));
        int level = 0;
        int[][] dirs = new int[][] {{-1, -1}, {-1, 0}, {-1, 1},
                                    {0, -1}, {0, 1},
                                    {1, -1}, {1, 0}, {1, 1}};
        while (!bfs.isEmpty()) {
            List<Pair<Integer, Integer>> next = new ArrayList<>();
            for (Pair<Integer, Integer> coord : bfs) {
                if (coord.getKey() < 0 || coord.getKey() >= grid.length) {
                    continue;
                }
                if (coord.getValue() < 0 || coord.getValue() >= grid[0].length) {
                    continue;
                }
                if (seen[coord.getKey()][coord.getValue()]) {
                    continue;
                }
                if (grid[coord.getKey()][coord.getValue()] == 1) {
                    continue;
                }
                if (coord.getKey() == grid.length - 1 && coord.getValue() == grid[0].length - 1) {
                    return level + 1;
                }
                for (int[] dir : dirs) {
                    next.add(new Pair<>(coord.getKey() + dir[0], coord.getValue() + dir[1]));
                }
                seen[coord.getKey()][coord.getValue()] = true;
            }
            bfs = next;
            level++;
        }
        return -1;
    }
}

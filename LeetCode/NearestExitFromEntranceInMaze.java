class Solution {
    // Can use a mix of BFS, heap, and a seen matrix
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int closest = Integer.MAX_VALUE;

    public int nearestExit(char[][] maze, int[] entrance) {
        boolean[][] seen = new boolean[maze.length][maze[0].length];
        PriorityQueue<int[]> bfs = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        bfs.offer(new int[] {0, entrance[0], entrance[1]}); // steps, i, j
        seen[entrance[0]][entrance[1]] = true;

        while (!bfs.isEmpty()) {
            int[] curr = bfs.poll();
            int steps = curr[0];
            int i = curr[1];
            int j = curr[2];
            
            seen[i][j] = true;

            if (steps != 0
                && (i == 0 || j == 0
                || i == maze.length - 1 || j == maze[0].length - 1)) {
                return steps;
            }
            for (int[] dir : dirs) {
                int nextI = dir[0] + i;
                int nextJ = dir[1] + j;
                // Check if we're in bounds
                if (nextI < 0 || nextJ < 0 || nextI >= maze.length || nextJ >= maze[0].length) {
                    continue;
                }
                if (maze[nextI][nextJ] == '+') {
                    continue;
                }
                if (seen[nextI][nextJ]) {
                    continue;
                }
                // Check if the step is less
                seen[nextI][nextJ] = true;
                bfs.offer(new int[] {steps + 1, nextI, nextJ});
            }
        }
        return -1;
    }
}

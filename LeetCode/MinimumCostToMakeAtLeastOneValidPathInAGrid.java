class Solution {
    public int minCost(int[][] grid) {
        // djik with pq on min moves, exploring each direction at each step, should do it
        // need to also hold the state to not step on any previous states
        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> a.compareTo(b));
        heap.offer(new State(0, grid[0][0], 0, 0));
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{
            {0,0}, 
            /*right*/{0,1}, 
            /*left*/{0,-1}, 
            /*lower*/{1,0}, 
            /*upper*/{-1,0}};
        boolean[][] seen = new boolean[m][n];

        while (!heap.isEmpty()) {
            // System.out.println(heap.toString());
            State curr = heap.poll();
            seen[curr.i][curr.j] = true;
            // See if we reached the end
            if (curr.i == m - 1 && curr.j == n - 1) {
                return curr.cost;
            }
            // Venture with the current state
            int nextI = dirs[curr.dir][0] + curr.i;
            int nextJ = dirs[curr.dir][1] + curr.j;
            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && !seen[nextI][nextJ]) {
                State next = new State(curr.cost, grid[nextI][nextJ], nextI, nextJ);
                heap.offer(next);
            }
            // Go through the rest of the directions and see if it is better
            for (int i = 1; i <= 4; i++) {
                if (i == curr.dir) {
                    continue;
                }
                nextI = dirs[i][0] + curr.i;
                nextJ = dirs[i][1] + curr.j;
                if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && !seen[nextI][nextJ]) {
                    // System.out.println("Reached");
                    State next = new State(curr.cost + 1, grid[nextI][nextJ], nextI, nextJ);
                    heap.offer(next);
                }
            }
        }
        return -1;
    }
    
    private class State implements Comparable {
        int cost, dir, i, j;
        
        public State(int cost, int dir, int i, int j) {
            this.cost = cost;
            this.dir = dir;
            this.i = i;
            this.j = j;
        }
        
        @Override
        public int compareTo(Object o) {
            State other = (State) o;
            return this.cost - other.cost;
        }
        
        @Override
        public String toString() {
            return "{" + i + ", " + j + "} cost: " + cost + " dir: " + dir;
        }
    }
}

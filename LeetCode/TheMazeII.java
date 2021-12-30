class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // Create a graph like system
        // There's at most 4 other locations the ball can go to at any point
        // We shouldn't revisit old locations unless we have reached there with a
        // cheaper distance. Then we have to reevaluate its neighs
        // Once we hit the end we can return the distance cost
        // Might have to find neighs on the fly, once we find it we can cache them
        int[][] shortest = new int[maze.length][maze[0].length];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]); // i, j, distance
        
        // init
        for (int i = 0; i < shortest.length; i++) {
            Arrays.fill(shortest[i], Integer.MAX_VALUE);
        }
        shortest[start[0]][start[1]] = 0;
        heap.offer(new int[]{start[0], start[1], 0});
        
        HashMap<Pair<Integer, Integer>, List<int[]>> pointToNeighs = new HashMap<>();
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return curr[2];
            }
            int distToCurr = curr[2];
            getNeighs(pointToNeighs, curr[0], curr[1], maze);
            for (int[] neigh : pointToNeighs.getOrDefault(new Pair<>(curr[0], curr[1]), new ArrayList<>())) {
                // System.out.println("Reached");
                int distThroughCurr = distToCurr + neigh[2];
                if (distThroughCurr < shortest[neigh[0]][neigh[1]]) {
                    shortest[neigh[0]][neigh[1]] = distThroughCurr;
                    heap.offer(new int[]{neigh[0], neigh[1], distThroughCurr});
                }
            }
        }
        // for (int[] row : shortest) {
        //     System.out.println(Arrays.toString(row));
        // }
        int res = shortest[destination[0]][destination[1]];
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private int[][] coords = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private void getNeighs(HashMap<Pair<Integer, Integer>, List<int[]>> pointToNeighs, int i, int j, int[][] map) {
        int[] coord = new int[]{i, j};
        if (pointToNeighs.containsKey(coord)) {
            return;
        }
        List<int[]> neighs = new ArrayList<>();
        // System.out.print("" + i + ", " + j + " neighs: ");
        for (int[] c : coords) {
            int[] neigh = getNeigh(coord, c, map);
            if (neigh[2] == 0) {
                continue;
            }
            neighs.add(neigh);
        }
        // for (int[] neigh : neighs) {
        //     System.out.print(Arrays.toString(neigh));
        // }
        pointToNeighs.put(new Pair<>(i, j), neighs);
        // System.out.println();
    }
    
    private int[] getNeigh(int[] s, int[] coord, int[][] map) {
        int dist = 0;
        int[] start = Arrays.copyOf(s, s.length);
        while (true) {
            int candI = start[0] + coord[0];
            int candJ = start[1] + coord[1];
            if (candI >= 0 && candI < map.length
               && candJ >= 0 && candJ < map[0].length
               && map[candI][candJ] == 0) {
                start[0] = candI;
                start[1] = candJ;
                dist++;
            } else {
                break;
            }
        }
        // System.out.print(Arrays.toString(start) + "dist: " + dist + ", ");
        return new int[]{start[0], start[1], dist};
    }
}

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // We can djikstra's with every node as a source and see how much nodes we can reach until we hit the threshold
        // Otherwise we can do a bfs from each node with a graph data structure and see how much nodes we can reach
        // before we hit the threshold
        // Both approaches would work here. djik would be more fun since I'm practicing it
        // As for runtime: djik would be O(n^2) worst case
        // bfs would also be O(n^2) worst case
        // Let's just do djik
        int[][] adj = new int[n][n];
        for (int[] edge : edges) {
            adj[edge[0]][edge[1]] = edge[2];
            adj[edge[1]][edge[0]] = edge[2];
        }
        int[] reach = new int[n];
        
        int res = Integer.MAX_VALUE;
        int city = 0;
        for (int node = 0; node < n; node++) {
            PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]); // Queue of [node, distance]
            heap.offer(new int[] {node, 0});
            int[] distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[node] = 0;
            int seen = 0;
            while (!heap.isEmpty()) {
                int[] curr = heap.poll();
                for (int neigh = 0; neigh < n; neigh++) {
                    if (adj[curr[0]][neigh] != 0) {
                        int costThroughNode = adj[curr[0]][neigh] + distances[curr[0]];
                        if (costThroughNode <= distanceThreshold && costThroughNode < distances[neigh]) {
                            if (distances[neigh] == Integer.MAX_VALUE) {
                                seen++;
                            }
                            distances[neigh] = costThroughNode;
                            heap.offer(new int[] {neigh, costThroughNode});
                        }
                    }
                }
            }
            if (seen <= res) {
                res = seen;
                city = node;
            }
            // System.out.println(Arrays.toString(distances[node]));
        }
        // for (int[] row : adj) {
        //     System.out.println(Arrays.toString(row));
        // }
        return city;
    }
}

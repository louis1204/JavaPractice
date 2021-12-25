class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Given source and times that represent a weighted edge, return the time it takes for all nodes to receive signal
        // This can me done by finding the max of the distance array
        int[][] adjMatrix = new int[n + 1][n + 1];
        for (int i = 0; i < adjMatrix.length; i++) {
            Arrays.fill(adjMatrix[i], -1);
        }
        for (int[] time : times) {
            adjMatrix[time[0]][time[1]] = time[2];
        }
        int[] djik = new int[n + 1];
        Arrays.fill(djik, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // pq of [node, distance], sort by distance
        djik[k] = 0;
        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            for (int neigh = 1; neigh <= n; neigh++) {
                if (adjMatrix[curr[0]][neigh] != -1) {
                    int distThroughCurr = djik[curr[0]] + adjMatrix[curr[0]][neigh];
                    if (distThroughCurr < djik[neigh]) {
                        djik[neigh] = distThroughCurr;
                        pq.offer(new int[]{neigh, distThroughCurr});
                    }
                }
            }
        }
        int max = -1;
        for (int i = 1; i < djik.length; i++) {
            if (djik[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, djik[i]);
        }
        return max;
    }
}

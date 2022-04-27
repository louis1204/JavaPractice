class Solution {
    public int minCostConnectPoints(int[][] points) {
        // Construct a MST. Construct all edges then use Prims to construct the graph
        int min = 0;
        int[] cost = new int[points.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> adj = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    adj.offer(new int[] {i, j, getDist(points[i], points[j])});
                }
            }
        }
        int[] unionFind = new int[points.length];
        for (int i = 0; i < unionFind.length; i++) {
            unionFind[i] = i;
        }
        int edgesUsed = 0;
        while (!adj.isEmpty() && edgesUsed < points.length - 1) {
            int[] curr = adj.poll();
            int a = curr[0];
            int b = curr[1];
            int dist = curr[2];
            // See if we can join
            int aParent = parent(unionFind, a);
            int bParent = parent(unionFind, b);
            
            if (aParent != bParent) {
                // We can join
                edgesUsed++;
                min += dist;
                unionFind[aParent] = bParent;
            }
        }
        
        return min;
    }
    
    private int parent(int[] unionFind, int node) {
        while (unionFind[node] != node) {
            int parent = parent(unionFind, unionFind[node]);
            unionFind[node] = parent;
            return parent;
        }
        return node;
    }
    
    private int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}

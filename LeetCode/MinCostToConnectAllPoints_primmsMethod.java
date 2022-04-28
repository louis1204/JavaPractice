class Solution {
    public int minCostConnectPoints(int[][] points) {
        // Construct a MST. Use prims, start at 0, calculate all dist to it, get the next min, update non seens if lower
        int[] cost = new int[points.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        
        boolean[] seen = new boolean[points.length];
        
        Set<Integer> mst = new HashSet<>();
        
        int res = 0;
        while (mst.size() != points.length) {
            int smallestNonSeen = getSmallestNonseen(seen, cost);
            seen[smallestNonSeen] = true;
            mst.add(smallestNonSeen);
            res += cost[smallestNonSeen];
            updateIfNeeded(smallestNonSeen, cost, points, seen);
        }
        
        return res;
    }
    
    int getSmallestNonseen(boolean[] seen, int[] cost) {
        int smallest = Integer.MAX_VALUE;
        int ind = -1;
        for (int i = 0; i < seen.length; i++) {
            if (!seen[i] && cost[i] < smallest) {
                ind = i;
                smallest = cost[i];
            }
        }
        return ind;
    }
    
    private void updateIfNeeded(int ind, int[] cost, int[][] points, boolean[] seen) {
        for (int i = 0; i < cost.length; i++) {
            if (seen[i] || i == ind) continue;
            int dist = getDist(points[i], points[ind]);
            if (dist < cost[i]) {
                cost[i] = dist;
            }
        }
    }
    
    private int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}

class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        // int MAX = (int) 5e4 + 1;
        int[][] dist = new int[colors.length][3];
        for (int[] tres : dist) {
            Arrays.fill(tres, Integer.MAX_VALUE);
        }
        // Go forward and set the min dist from the previous 1,2,3
        int[] prevs = new int[4];
        Arrays.fill(prevs, Integer.MAX_VALUE);
        for (int i = 0; i < colors.length; i++) {
            // set the current color
            prevs[colors[i]] = i;
            // set the shortest
            dist[i][0] = Math.min(
                dist[i][0],
                prevs[1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - prevs[1]);
            dist[i][1] = Math.min(
                dist[i][1],
                prevs[2] == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - prevs[2]);
            dist[i][2] = Math.min(
                dist[i][2],
                prevs[3] == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - prevs[3]);
            // System.out.println(Arrays.toString(dist[i]));
        }
        // Do the same for backward
        Arrays.fill(prevs, Integer.MAX_VALUE);
        for (int i = colors.length - 1; i >= 0; i--) {
            // set the current color
            prevs[colors[i]] = i;
            // set the shortest
            dist[i][0] = Math.min(
                dist[i][0],
                prevs[1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : prevs[1] - i);
            dist[i][1] = Math.min(
                dist[i][1],
                prevs[2] == Integer.MAX_VALUE ? Integer.MAX_VALUE : prevs[2] - i);
            dist[i][2] = Math.min(
                dist[i][2],
                prevs[3] == Integer.MAX_VALUE ? Integer.MAX_VALUE : prevs[3] - i);
            // System.out.println(Arrays.toString(dist[i]));
        }
        // Make our res
        List<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            int d = dist[q[0]][q[1] - 1];
            res.add(d == Integer.MAX_VALUE ? -1 : d);
        }
        return res;
    }
}

class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int maxSaving = Integer.MIN_VALUE;
        int totalDist = 0;
        for (int[] nut : nuts) {
            int dist = 2 * getDist(tree, nut);
            totalDist += dist;
            maxSaving = Math.max(maxSaving, dist - (getDist(squirrel, nut) + getDist(tree, nut)));
        }
        return totalDist - maxSaving;
    }
    
    private int getDist(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}

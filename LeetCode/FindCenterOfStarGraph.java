class Solution {
    public int findCenter(int[][] edges) {
        // Once we find a dupe, we can return that number
        HashSet<Integer> seen = new HashSet<>();
        for (int[] edge: edges) {
            if (seen.contains(edge[0])) {
                return edge[0];
            }
            if (seen.contains(edge[1])) {
                return edge[1];
            }
            seen.add(edge[0]);
            seen.add(edge[1]);
        }
        return -1; // Shouldn't reach
    }
}

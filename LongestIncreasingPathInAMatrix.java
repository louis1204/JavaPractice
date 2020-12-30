class Solution {
    // Cache answers and dfs recursively
    HashMap<Pair<Integer, Integer>, Integer> pointLongest =
        new HashMap<>();
    int longest = 0;
    int[][] dirs = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                longest = Math.max(longest, helper(matrix, i, j));
            }
        }
        return longest;
    }
    
    private int helper(int[][] matrix, int i, int j) {
        Pair point = new Pair<>(i, j);
        if (pointLongest.containsKey(point)) {
            return pointLongest.get(point);
        }
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length) {
            return 0;
        }
        int max = 0;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI < 0 || nextI >= matrix.length || nextJ < 0 || nextJ >= matrix[nextI].length) {
                continue;
            }
            if (matrix[nextI][nextJ] > matrix[i][j]) {
                max = Math.max(max, helper(matrix, i + dir[0], j + dir[1]));
            }
        }
        pointLongest.put(point, max + 1);
        // System.out.println(pointLongest.toString());
        return max + 1;
    }
}

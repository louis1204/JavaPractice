class Solution {
    int[][] memo = null;
    
    public int minimumTotal(List<List<Integer>> triangle) {
        // DFS with caching?
        // Caching with a 2d array is straight forward
        memo = new int[triangle.size()][triangle.size()];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return helper(triangle, 0, 0);
    }
    
    private int helper(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()) {
            return 0;
        }
        if (memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }
        int cost1 = helper(triangle, row + 1, col) + triangle.get(row).get(col);
        int cost2 = helper(triangle, row + 1, col + 1) + triangle.get(row).get(col);
        memo[row][col] = Math.min(cost1, cost2);
        return memo[row][col];
    }
}

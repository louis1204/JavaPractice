class Solution {
    public int uniquePathsWithObstacles(int[][] obs) {
        // Backtracking with memoization
        HashMap<Pair<Integer, Integer>, Integer> memo = new HashMap<>();
        helper(0, 0, obs, memo);
        return memo.getOrDefault(new Pair<>(0, 0), obs[0][0] == 0 ? 1 : 0);
    }
    
    public int helper(int i, int j, int[][] obs, HashMap<Pair<Integer, Integer>, Integer> memo) {
        Pair<Integer, Integer> coord = new Pair<>(i, j);
        if (i >= obs.length || j >= obs[0].length) {
            return 0;
        }
        if (memo.containsKey(coord)) {
            return memo.get(coord);
        }
        if (obs[i][j] == 1) {
            return 0;
        }
        if (i == obs.length - 1 && j == obs[0].length - 1) {
            return 1;
        }
        int curr = helper(i + 1, j, obs, memo) + helper(i, j + 1, obs, memo);
        memo.put(coord, curr);
        return curr;
    }
}

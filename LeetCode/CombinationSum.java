class Solution {
    Set<List<Integer>> res = new HashSet<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        // backtrack
        helper(0, new ArrayList<>(), 0, target, candidates);
        return res.stream().collect(Collectors.toList());
    }
    
    private void helper(int ind, List<Integer> cand, int sum, int target, int[] candidates) {
        if (sum == target) {
            List<Integer> candCopy = new ArrayList<>() {{
                addAll(cand);
            }};
            res.add(candCopy);
            return;
        }
        if (ind >= candidates.length || sum > target) {
            return;
        }
        // Add
        cand.add(candidates[ind]);
        helper(ind + 1, cand, sum + candidates[ind], target, candidates);
        // Don't add
        cand.remove(cand.size() - 1);
        helper(ind + 1, cand, sum, target, candidates);
        // Stay at curr
        cand.add(candidates[ind]);
        helper(ind, cand, sum + candidates[ind], target, candidates);
        cand.remove(cand.size() - 1);
    }
}

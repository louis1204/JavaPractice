class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        // back track
        // Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();
        helper(nums, 0, res, new ArrayList<>());
        return res.stream().collect(Collectors.toList());
    }

    private void helper(int[] nums, int ind, HashSet<List<Integer>> res, List<Integer> curr) {
        if (ind == nums.length) {
            if (curr.size() >= 2) {
                res.add(copy(curr));
            }
            return;
        }
        // Don't add
        helper(nums, ind + 1, res, curr);
        // Add if possible
        if (curr.isEmpty() || nums[ind] >= curr.get(curr.size() - 1)) {
            curr.add(nums[ind]);
            helper(nums, ind + 1, res, curr);
            // Backtrack
            curr.remove(curr.size() - 1);
        }
    }

    private List<Integer> copy(List<Integer> other) {
        List<Integer> temp = new ArrayList<>();
        temp.addAll(other);
        return temp;
    }
}

class Solution {
    Set<List<Integer>> subsets = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return subsets.stream().collect(Collectors.toList());
    }
    
    private void helper(int[] nums, int index, List<Integer> curr) {
        if (index >= nums.length) {
            List<Integer> copy = new ArrayList<>() {{
                addAll(curr);
            }};
            copy.sort((a, b) -> a - b);
            subsets.add(copy);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            List<Integer> notAdd = new ArrayList<>() {{
                addAll(curr);
            }};
            curr.add(nums[i]);
            helper(nums, i + 1, curr);
            helper(nums, i + 1, notAdd);
            curr.remove(curr.size() - 1);
        }
    }
}

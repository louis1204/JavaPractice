class Solution {
    int[] memo = null;
    
    int max = 0;
    public int arrayNesting(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        // brute force with memo of position to longest length
        for (int i = 0; i < nums.length; i++) {
            helper(nums, i, new boolean[nums.length], 0);
        }
        return max;
    }
    
    private int helper(int[] nums, int pos, boolean[] seen, int length) {
        if (seen[pos]) {
            max = Math.max(max, length);
            return 1;
        }
        if (memo[pos] != -1) {
            return memo[pos];
        }
        seen[pos] = true;
        int lengthToEnd = helper(nums, nums[pos], seen, length + 1);
        memo[pos] = lengthToEnd;
        return lengthToEnd + 1;
    }
}

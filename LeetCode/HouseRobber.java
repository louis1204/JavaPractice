class Solution {
    public int rob(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int oneDoorDown = i - 1;
            int twoDoorsDown = i - 2;
            nums[i] = Math.max(
                twoDoorsDown >= 0 ? nums[i] + nums[twoDoorsDown] : nums[i], // include this one
                nums[oneDoorDown] // skip this one
            );
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}

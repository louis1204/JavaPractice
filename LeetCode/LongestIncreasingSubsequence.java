class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int tempMax = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    tempMax = Math.max(tempMax, dp[j] + 1);
                }
            }
            dp[i] = tempMax;
            max = Math.max(max, tempMax);
        }
        return max;
    }
}

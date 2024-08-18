class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // sliding window
        double max = 0.0;
        int left = 0;
        int right = 0;
        double curr = max;
        while (right < k) {
            curr += nums[right++];
        }
        max = curr / k;
        while (right < nums.length) {
            curr += nums[right++];
            curr -= nums[left++];
            max = Math.max(max, curr / k);
        }
        return max;
    }
}

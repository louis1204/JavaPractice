class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0;
        for (int num : nums) {
            if (num == 0) {
                max = Math.max(curr, max);
                curr = 0;
                continue;
            }
            curr++;
        }
        max = Math.max(curr, max);
        return max;
    }
}

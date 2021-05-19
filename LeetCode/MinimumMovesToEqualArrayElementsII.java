class Solution {
    public int minMoves2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        if (nums.length % 2 == 1) {
            return getMoves(nums, nums[nums.length / 2]);
        }
        return Math.min(getMoves(nums, nums[nums.length / 2]), getMoves(nums, nums[nums.length / 2 - 1]));
    }
    
    private int getMoves(int[] nums, int mid) {
        int res = 0;
        for (int num : nums) {
            res += Math.abs(mid - num);
        }
        return res;
    }
}

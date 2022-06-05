class Solution {
    public int partitionArray(int[] nums, int k) {
        // Sort then iterate through the array and keep track of min and increase groups if diff is greater than k
        Arrays.sort(nums);
        int min = nums[0];
        int groups = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - min > k) {
                groups++;
                min = nums[i];
            }
        }
        return groups;
    }
}

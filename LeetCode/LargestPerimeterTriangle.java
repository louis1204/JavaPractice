class Solution {
    public int largestPerimeter(int[] nums) {
        // For the 3 sides to form a triangle, find the biggest side, that will be the base
        // The other 2 sides need to sum up > the base, otherwise they won't be able
        // to meet
        Arrays.sort(nums);
        for (int i = nums.length; i >= 3; i--) {
            int base = nums[i - 1];
            int othersSum = nums[i - 2] + nums[i - 3];
            if (othersSum > base) {
                return othersSum + base;
            }
        }
        return 0;
    }
}

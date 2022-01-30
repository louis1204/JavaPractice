class Solution {
    public void rotate(int[] nums, int k) {
        int[] rotated = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int newSpot = (i + k) % nums.length;
            rotated[newSpot] = nums[i];
        }
        for (int i = 0; i < rotated.length; i++)
            nums[i] = rotated[i];
    }
}

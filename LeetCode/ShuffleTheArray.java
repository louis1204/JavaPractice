class Solution {
    public int[] shuffle(int[] nums, int n) {
        // First ptr at the beginning
        // Get the middle by just dividing by two and that will be second ptr
        int[] res = new int[nums.length];
        int ptr1 = 0;
        int ptr2 = n;
        int resPtr = 0;
        while (ptr2 < nums.length) {
            res[resPtr] = nums[ptr1];
            res[resPtr + 1] = nums[ptr2];
            ptr1++;
            ptr2++;
            resPtr += 2;
        }
        return res;
    }
}

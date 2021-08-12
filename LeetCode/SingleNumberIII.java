class Solution {
    public int[] singleNumber(int[] nums) {
        int mask = 0;
        
        for (int num : nums) {
            mask ^= num;
        }
        int rightMost = mask & -mask;
        int x = 0;
        for (int num : nums) {
            if ((rightMost & num) != 0) {
                x ^= num;
            }
        }
        return new int[] {x, mask ^ x};
    }
}

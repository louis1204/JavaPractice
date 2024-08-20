class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] forwardSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                forwardSum[i] = nums[i];
            } else {
                forwardSum[i] = nums[i] + forwardSum[i - 1];
            }
        }
        int[] backwardSum = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                backwardSum[i] = nums[i];
            } else {
                backwardSum[i] = nums[i] + backwardSum[i + 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (backwardSum[i + 1] == 0) {
                    return i;
                }
            } else if (i == nums.length - 1) {
                if (forwardSum[i - 1] == 0) {
                    return i;
                }
            } else if (forwardSum[i - 1] == backwardSum[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}

class Solution {
    int mod = (int)1e9 + 7;
    public int waysToSplit(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }
        int res = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int left = prefix[i - 1];
            int findLeft = helper(prefix, i, left, true);
            int findRight = helper(prefix, i, left, false);
            if (findLeft == -1 || findRight == -1) {
                continue;
            }
            res += (findRight - findLeft + 1) % mod;
            res %= mod;
        }
        return res;
    }
    
    private int helper(int[] prefix, int index, int firstSum, boolean isLeft) {
        int left = index;
        int right = prefix.length - 2;
        
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int second = prefix[mid] - prefix[index - 1];
            int third = prefix[prefix.length - 1] - prefix[mid];
            if (firstSum <= second && second <= third) {
                if (isLeft) {
                    res = mid;
                    right = mid - 1;
                } else {
                    res = mid;
                    left = mid + 1;
                }
            } else if (firstSum > second) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}

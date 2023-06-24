class Solution {
    public int[] getAverages(int[] nums, int k) {
        // sliding window
        if (nums.length % 2 != 0 && k > nums.length / 2) {
            Arrays.fill(nums, -1);
            return nums;
        } else if (nums.length % 2 == 0 && k >= nums.length / 2) {
            Arrays.fill(nums, -1);
            return nums;
        }
        long divisor = 2 * k + 1;
        // System.out.println("divisor is " + divisor);
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        long sum = 0;
        for (int i = 0; i <= k * 2; i++) {
            sum += nums[i];
        }
        int head = 0;
        int tail = k * 2 + 1;
        for (int i = k; i < res.length - k; i++) {
            res[i] = (int) (sum / divisor);
            // System.out.println("Sum is " + sum);
            // System.out.println("Head is " + nums[head]);
            if (tail < nums.length) {
                // System.out.println("Tail is " + nums[tail]);
                sum -= nums[head++];
                sum += nums[tail++];
            }
        }
        return res;
    }
}

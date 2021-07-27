class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int dist = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int temp = nums[i] + nums[j] + nums[k];
                    if ((int)Math.abs(target - temp) < dist) {
                        dist = (int)Math.abs(target - temp);
                        res = temp;
                    }
                    // if (temp > target && temp > res) { 
                    //     return res;
                    // }
                }
            }
        }
        return res;
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int delay = 0;
        int lead = 1;
        while (lead < nums.length) {
            if (nums[lead] == nums[delay]) {
                lead++;
                continue;
            } else {
                delay++;
                nums[delay] = nums[lead];
                lead++;
            }
        }
        return delay + 1;
    }
}

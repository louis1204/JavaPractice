class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int max = 0;
        int curr = 0;
        int ptr1 = 0;
        int ptr2 = 0;
        while (ptr2 < nums.length) {
            // Invalid case
            if (seen.contains(nums[ptr2])) {
                max = Math.max(max, curr);
                curr -= nums[ptr1];
                seen.remove(nums[ptr1]);
                ptr1++;
            } else {
                // continue expanding window
                seen.add(nums[ptr2]);
                curr += nums[ptr2++];
            }
        }
        return Math.max(max, curr);
    }
}

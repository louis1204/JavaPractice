class Solution {
    public int longestSubarray(int[] nums) {
        // Is there a prefix sum approach? No
        // 1, 2, 3, 3, 2, 2
        // Maybe a greedy approach?
        // Once we have a 0 in one of the bits, it will always be less
        // Essentially we want to longest subarray of same values
        // If we have differing values, the 0's will force the & to be less
        int largest = nums[0];
        // Since the largest value may have multiple contiguous parts, have an array
        List<Integer> lengthOfLongest = new ArrayList<>();
        lengthOfLongest.add(1);
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int prev = nums[i - 1];
            if (curr >= largest) {
                if (curr == prev) {
                    temp++;
                    int arrSize = lengthOfLongest.size();
                    lengthOfLongest.set(arrSize - 1, lengthOfLongest.get(arrSize - 1) + 1);
                } else {
                    temp = 1;
                    if (largest == curr) {
                        lengthOfLongest.add(1);
                    } else {
                        lengthOfLongest.clear();
                        lengthOfLongest.add(1);
                    }
                    largest = curr;
                }
            }
        }
        int res = 0;
        for (int curr : lengthOfLongest) {
            res = Math.max(res, curr);
        }
        return res;
    }
}

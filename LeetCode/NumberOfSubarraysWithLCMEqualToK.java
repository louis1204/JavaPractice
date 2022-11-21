class Solution {
    public int subarrayLCM(int[] nums, int k) {
        // If there is 1 number the LCM is itself
        // If there are 2 numbers, the LCM is some multiple of either number
        // Similar for n numbers
        // To get the amount of contiguous arrays that have LCM k, we'd have to analyze each element
        
        // Since the length is 1000, we can get away with an n^2 algorithm
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k % nums[i] != 0 || nums[i] > k) {
                continue;
            }
            int lcmSoFar = nums[i];
            // System.out.println("Start ind " + i);
            for (int j = i; j < nums.length; j++) {
                if (k % nums[j] != 0 || nums[j] > k) {
                    break;
                }
                int bigger = Math.max(lcmSoFar, nums[j]);
                int temp = bigger;
                while (bigger % nums[j] != 0 || bigger % lcmSoFar != 0) {
                    bigger += temp;
                    // System.out.println("bigger: " + bigger);
                }
                if (bigger > k) {
                    break;
                }
                lcmSoFar = bigger;
                // System.out.println("End ind " + j);
                // System.out.println("lcm " + lcmSoFar);
                if (lcmSoFar == k) {
                    count++;
                }
            }
        }
        return count;
    }
}

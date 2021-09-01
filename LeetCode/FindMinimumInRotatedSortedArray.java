class Solution {
    public int findMin(int[] nums) {
        // We can do an O(n) approach
        // int min = Integer.MAX_VALUE;
        // for (int num : nums) {
        //     min = Math.min(min, num);
        // }
        // return min;
        
        // Try a log(n) aproach
        // We need to find the rotation point
        // Take the lo = 0, hi = nums.length - 1
        // Take the mid point, if it's less than lo, then we can say the pivot is somewhere below
        // set hi = mid
        // If mid point is greater than lo, but higher than hi, then the pivot is above
        // set lo = mid
        // If the midpoint is greater than lo and less than hi
        // set hi = mid
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] < nums[lo]) {
                hi = mid - 1;
                continue;
            }
            if (nums[hi] < nums[mid]) {
                lo = mid + 1;
                continue;
            }
            hi = mid - 1;
        }
        return nums[lo];
    }
}

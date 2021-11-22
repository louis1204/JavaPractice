class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int leftSize = mid - lo;
            int rightSize =  hi - mid;
            // System.out.println("mid=" + mid);
            // System.out.println("leftSize=" + leftSize);
            // System.out.println("rightSize=" + rightSize);
            if (mid > 0 && nums[mid] == nums[mid - 1]) {
                if (leftSize % 2 == 0) {
                    hi = mid - 2;
                    // System.out.println("1took left");
                } else {
                    lo = mid + 1;
                    // System.out.println("1took right");
                }
            } else if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                if (rightSize % 2 == 0) {
                    lo = mid + 2;
                    // System.out.println("2took right");
                } else {
                    hi = mid - 1;
                    // System.out.println("2took left");
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
    }
}


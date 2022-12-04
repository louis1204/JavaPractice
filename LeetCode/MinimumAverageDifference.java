class Solution {
    public int minimumAverageDifference(int[] nums) {
        // We can do a prefix average going forward and backward stored in 2 arrays
        // Then to calculate the min average diff, we just look at the element going forward - element going backward
        // We use double since there might be integer overflow
        double[] forward = new double[nums.length];
        forward[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            forward[i] = nums[i] + forward[i - 1];
        }
        for (int i = 1; i < nums.length; i++) {
            forward[i] = (int)(forward[i] / (i + 1));
        }
        double[] backward = new double[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            backward[i] = nums[i + 1] + backward[i + 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            backward[i] = (int) (backward[i] / Math.abs(nums.length - 1 - i));
        }
        // System.out.println(Arrays.toString(forward));
        // System.out.println(Arrays.toString(backward));
        int ind = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int avgDiff = (int)Math.abs(forward[i] - backward[i]);
            // if (i == 49988 || i == 29403) {
            //     System.out.println("ind: " + i + " diff: " + avgDiff + " forward: " + forward[i] + " backward: " + backward[i] + " num: " + nums[i]);
            // }
            if (avgDiff < min) {
                ind = i;
                min = avgDiff;
            }
        }
        return ind;
    }
}

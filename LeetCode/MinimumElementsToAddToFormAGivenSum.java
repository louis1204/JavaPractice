class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        // Greedy
        // Get current sum
        long sum = 0;
        for (int num : nums) sum += num;
        
        if (sum == goal) return 0;
        
        boolean isAdd = goal >=sum;
        int amt = 0;
        // if (isAdd) {
            return (int) Math.ceil(Math.abs(goal - sum) / (double) limit);
            
        // } else {
        //     while (sum > goal) {
        //         sum -= limit;
        //         amt++;
        //     }
        // }
        // return amt;
    }
}

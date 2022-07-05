class Solution {
    public int longestConsecutive(int[] nums) {
        // Put all nums in a set
        // Make another hashmap of num and it's longest increasing sequence starting with that num
        // Then analyze that for all nums in the set
        // Return the longest
        Set<Integer> n = new HashSet<>();
        for (int num : nums) {
            n.add(num);
        }
        
        HashMap<Integer, Integer> dp = new HashMap<>();
        int max = 0;
        for (Integer curr : n) {
            max = Math.max(max, helper(n, dp, curr));
        }
        return max;
    }
                           
    private int helper(Set<Integer> nums, HashMap<Integer, Integer> dp,
                      int curr) {
        if (!nums.contains(curr)) {
            return 0;
        }
        if (dp.containsKey(curr)) {
            return dp.get(curr);
        }
        int subseq = 1 + helper(nums, dp, curr + 1);
        dp.put(curr, subseq);
        return subseq;
    }
}

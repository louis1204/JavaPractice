class Solution {
    public int findMaxK(int[] nums) {
        int max = -1;
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (seen.contains(-n)) {
                max = Math.max(Math.abs(n), max);
            }
            seen.add(n);
        }
        return max;
    }
}

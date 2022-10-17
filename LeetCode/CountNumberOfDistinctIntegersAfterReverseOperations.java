class Solution {
    public int countDistinctIntegers(int[] nums) {
        int res = 0;
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            int rev = getRev(n);
            if (!seen.contains(n)) {
                seen.add(n);
                res++;
            }
            if (!seen.contains(rev)) {
                seen.add(rev);
                res++;
            }
        }
        return res;
    }
    
    private int getRev(int n) {
        int res = 0;
        while (n > 0) {
            res *= 10;
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}

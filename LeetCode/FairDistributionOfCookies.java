class Solution {
    int max = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        // if we simulate we get an 8^8 complexity
        // Can we do this greedily? No
        // 8 ^ 8 is 16m ~ 1.6 * 10^7
        helper(0, cookies, new int[k], 0);
        return max;
    }
    
    private void helper(int ind, int[] cookies, int[] kids, int maxSoFar) {
        if (ind == cookies.length) {
            max = Math.min(max, maxSoFar);
            return;
        }
        for (int kid = 0; kid < kids.length; kid++) {
            kids[kid] += cookies[ind];
            helper(ind + 1, cookies, kids, Math.max(kids[kid], maxSoFar));
            kids[kid] -= cookies[ind];
        }
    }
}

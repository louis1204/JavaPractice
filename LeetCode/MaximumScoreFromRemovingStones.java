class Solution {
    int res = 0;
    public int maximumScore(int a, int b, int c) {
        helper(a, b, c, 0);
        return res;
    }
    
    private void helper(int a, int b, int c, int score) {
        if ((a == 0 && b == 0) || (a == 0 && c == 0) || (b == 0 && c == 0)) {
            res = Math.max(score, res);
            return;
        }
        if ((a >= c && b >= c)) {
            helper(a - 1, b - 1, c, score + 1);
            return;
        }
        if ((a >= b && c >= b)) {
            helper(a - 1, b, c - 1, score + 1);
            return;
        }       
        if ((b >= a && c >= a)) {
            helper(a, b - 1, c - 1, score + 1);
            return;
        }
    }
}

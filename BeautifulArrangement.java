class Solution {
    int counts = 0;
    public int countArrangement(int n) {
        boolean[] used = new boolean[n];
        helper(used, 1, n);
        return counts;
    }
    
    private void helper(boolean[] used, int currentInd, int n) {
        if (currentInd > n) {
            counts++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            // Take
            if (!used[i - 1]) {
                if (currentInd % i == 0 || i % currentInd == 0) {
                    used[i - 1] = true;
                    helper(used, currentInd + 1, n);
                    used[i - 1] = false;
                }
            }
        }
    }
}

class Solution {
    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        if (k > num) {
            return -1;
        }
        // We can do a bottom up dp approach on the num value
        // Start at k and sub that value
        // dp(n) = Min(dp(n - k) + 1), for all k is a ones digit k
        int[] dp = new int[num + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        if (k != 0)
            dp[k] = 1;
        
        for (int i = k + 1; i <= num; i++) {
            int min = num + 1;
            for (int temp = k; temp <= i; temp += 10) {
                if (dp[i - temp] != -1) {
                    min = Math.min(dp[i - temp] + 1, min);
                }
            }
            if (min != num + 1) {
                dp[i] = min;
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[num];
    }
}

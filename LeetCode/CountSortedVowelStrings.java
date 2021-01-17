class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][6];
        for (int vowels = 1; vowels <= 5; vowels++) {
            dp[0][vowels] = dp[0][vowels - 1] + 1;
        }
        // Start at length = 1, but treat as length = 2
        for (int length = 1; length < n; length++) {
            for (int vowels = 1; vowels <= 5; vowels++) {
                dp[length][vowels] = dp[length][vowels - 1] + dp[length - 1][vowels];
            }
        }
        return dp[n - 1][5];
    }
}

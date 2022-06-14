class Solution {
    int[][] dp = null;
    int longest = 0;
    public int minDistance(String word1, String word2) {
        // Wasn't able to come up on own
        // Can use DP to find the longest common substring ending at index i, j for word1, word2 respectively
        dp = new int[word1.length()][word2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        helper(0, 0, word1, word2);
        return (word1.length() + word2.length()) - 2 * longest;
    }
    
    public int helper(int end1, int end2, String word1, String word2) {
        if (end1 == word1.length() || end2 == word2.length()) {
            return 0;
        }
        if (dp[end1][end2] != -1) {
            return dp[end1][end2];
        }
        int tempLongest = 0;
        if (word1.charAt(end1) == word2.charAt(end2)) {
            tempLongest = 1 + helper(end1 + 1, end2 + 1, word1, word2);
        } else {
            int max = 0;
            max = helper(end1 + 1, end2, word1, word2);
            max = Math.max(max, helper(end1, end2 + 1, word1, word2));
            tempLongest = max;
        }
        dp[end1][end2] = tempLongest;
        longest = Math.max(longest, tempLongest);
        return tempLongest;
    }
}

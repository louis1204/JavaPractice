class Solution {
    boolean[][] dp = null;
    
    public int countSubstrings(String s) {
        // Initialize the memo with the base case of each single letter being a pal
        // Then start increasing the size until we reach s.length, and check if substring
        // by comparing the end chars and the inner string if it's a substring
        dp = new boolean[s.length()][s.length()];
        int res = 0;
        // Initialize
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            res++;
        }
        // Go through the sizes
        for (int size = 1; size < s.length(); size++) {
            for (int i = 0; i < s.length(); i++) {
                if (i + size >= s.length()) {
                    break;
                }
                int end = i + size;
                // System.out.println(i + " " + end);
                boolean isPal = s.charAt(i) == s.charAt(end) && (i == end - 1 || dp[i + 1][end - 1]);
                dp[i][end] = isPal;
                if (isPal) {
                    res++;
                }
            }
        }
        return res;
    }
}

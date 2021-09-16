class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int[][] dp = new int[arr.length][2];
        // init
        // First starts with greater
        // Second starts with less than
        dp[0][0] = 1;
        dp[0][1] = 1;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 1) {
                if (arr[i - 1] > arr[i]) {
                    dp[i][0] = dp[i - 1][0] + 1;
                } else {
                    dp[i][0] = 1;
                }
                if (arr[i - 1] < arr[i]) {
                    dp[i][1] = dp[i - 1][1] + 1;
                } else {
                    dp[i][1] = 1;
                }
            } else {
                if (arr[i - 1] < arr[i]) {
                    dp[i][0] = dp[i - 1][0] + 1;
                } else {
                    dp[i][0] = 1;
                }
                if (arr[i - 1] > arr[i]) {
                    dp[i][1] = dp[i - 1][1] + 1;
                } else {
                    dp[i][1] = 1;
                }
            }
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        // for (int[] d : dp)
        //     System.out.println(Arrays.toString(d));
        return max;
    }
}

class Solution {
    public int countVowelPermutation(int n) {
        // int[] parents = new int[5];
        // parents[0] = 3; //a
        // parents[1] = 2; //e
        // parents[2] = 2; //i
        // parents[3] = 1; //o
        // parents[4] = 2; //u
        HashMap<Integer, List<Integer>> childToParents = new HashMap<>();
        childToParents.put(0, Arrays.asList(1, 2, 4)); //a
        childToParents.put(1, Arrays.asList(0, 2)); //e
        childToParents.put(2, Arrays.asList(1, 3)); //i
        childToParents.put(3, Arrays.asList(2)); //o
        childToParents.put(4, Arrays.asList(2, 3)); //u
        int MOD = (int) (1e9 + 7);
        // dp of num of vowels to length of string
        // Each entry is the number of permutations of length, j, ending with the vowel, i
        int[][] dp = new int[5][n];
        // Init for just one char
        for (int i = 0; i < 5; i++) {
            dp[i][0] = 1;
        }
        // For all the other columns, it'll be sum of permutations of previous length ending with
        // its parents
        for (int col = 1; col < n; col++) {
            for (int row = 0; row < 5; row++) {
                List<Integer> parents = childToParents.get(row);
                int sum = 0;
                for (Integer parent : parents) {
                    sum += dp[parent][col - 1];
                    sum %= MOD;
                }
                dp[row][col] = sum;
            }
            // dp[i+1][0] = (dp[i][4] + dp[i][1] + dp[i][2]) % MOD;
            // dp[i+1][1] = (dp[i][0] + dp[i][2]) % MOD;
            // dp[i+1][2] = (dp[i][3] + dp[i][1]) % MOD;
            // dp[i+1][3] = (dp[i][2]) % MOD;
            // dp[i+1][4] = (dp[i][2] + dp[i][3]) % MOD;
            // dp[col][0]
        }
        // for (int[] row : dp) {
        //     System.out.println(Arrays.toString(row));
        // }
        int res = 0;
        for (int row = 0; row < 5; row++) {
            res += dp[row][n - 1];
            res  %= MOD;
        }
        return res;
    }
}

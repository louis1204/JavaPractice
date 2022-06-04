class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // Create a dp array with each index representing the minimum amount of coins making that total
        // Fill with infinite equivalent
        // Arrays.fill(dp, Integer.MAX_VALUE); We don't want ot use MAX_VALUE due to overflow
        Arrays.fill(dp, amount + 1);
        // Set the 0th amount as 0
        dp[0] = 0;
        for (int amt = 1; amt <= amount; amt++) {
            // Now for each amount, iterate through the coins to see if we can make it
            for (int coin : coins) {
                if (amt - coin < 0) {
                    continue; // this coin is too large and will go over the current amount
                }
                dp[amt] = Math.min(dp[amt], 1 + dp[amt - coin]); // Set the dp's minimum if using this coin is less
            }
        }
        // finally check if the dp[amount] is <= amount, then we return it otherwise -1
        return dp[amount] <= amount ? dp[amount] : -1;
    }
}

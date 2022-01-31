class Solution {
    public int maximumWealth(int[][] accounts) {
        // int cust = 0;
        int wealth = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int temp = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                temp += accounts[i][j];
            }
            if (temp > wealth) {
                wealth = temp;
                // cust = i;
            }
        }
        return wealth;
    }
}

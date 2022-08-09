class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        // Seems like a knapsack problem
        // We store a cache of product to number of trees makeable
        // Then for each number we iterate each number less than it
        // If it's a factor, then we check to see if the other factor exists
        // Multiply, mod, accumulate into a sum
        int mod = (int) 1e9 + 7;
        HashMap<Integer, Long> numToWays = new HashMap<>();
        // Sort first
        Arrays.sort(arr);
        long totalWays = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            Long ways = 1l; // Start at 1 since itself is a way
            for (int j = 0; j < i; j++) {
                int factor1 = arr[j];
                if (num % factor1 == 0 && numToWays.containsKey(num / factor1)) {
                    ways = (ways + numToWays.get(factor1) * numToWays.get(num / factor1)) % mod;
                }
            }
            numToWays.put(num, ways);
            totalWays += ways;
            totalWays %= mod;
        }
        return (int)(totalWays % mod);
    }
}

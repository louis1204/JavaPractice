class Solution {
    int mod = (int)1e9 + 7;
    public int countPairs(int[] deliciousness) {
        int amountOfWays = 0;
        Arrays.sort(deliciousness);
        HashMap<Integer, Integer> count = new HashMap<>();
        int maxSoFar = 0;
        for (int del : deliciousness) {
            int pow = 0;
            int baseTwo = (int)Math.pow(2, pow);
            while (baseTwo <= maxSoFar + del) {
                amountOfWays += count.getOrDefault(baseTwo - del, 0) % mod;
                amountOfWays %= mod;
                pow++;
                baseTwo = (int)Math.pow(2, pow);
            }
            count.put(del, count.getOrDefault(del, 0) + 1);
            maxSoFar = del;
        }
        return amountOfWays;
    }
}

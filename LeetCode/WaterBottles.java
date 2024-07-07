class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // Just simulate
        int res = 0;
        int emptyBottles = 0;
        while (numBottles > 0) {
            res += numBottles; // drink
            emptyBottles += numBottles; // add these bottles to empty stash
            numBottles = emptyBottles / numExchange; // see how much we can exchange for full bottles
            emptyBottles -= numBottles * numExchange; // Remove  from our pool of empty bottles by the amt used
        }
        return res;
    }
}

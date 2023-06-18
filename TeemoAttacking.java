class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // go through the array and if the time series + duration - 1 is less than
        // the next time, just add that duration, otherwise we need to figure out the
        // diff
        int total = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i == timeSeries.length - 1) {
                total += duration;
            } else {
                int currAttackTime = timeSeries[i];
                int nextAttackTime = timeSeries[i + 1];
                if (currAttackTime + duration - 1 < nextAttackTime) {
                    total += duration;
                } else {
                    total += nextAttackTime - currAttackTime;
                }
            }
        }
        return total;
    }
}

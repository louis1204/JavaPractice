class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        // Can we just do a greedy algo?
        // if the sum of rolls + n / (m + n) > mean, then it's impossible
        // similarly, if the sum of rolls + 6 * n / (m + n) < mean, then it's impossible
        // otherwise, let's greedily make the dices as high as possible to try to hit the mean
        int sumM = 0;
        int m = rolls.length;
        for (int roll : rolls) {
            sumM += roll;
        }
        if (sumM + n > (m + n) * mean || (sumM + 6 * n) < (m + n) * mean) {
            return new int[0];
        }
        // Assume all 1's initially
        int[] res = new int[n];
        int sumN = n;
        int sumTarget = mean * (m + n);
        Arrays.fill(res, 1);
        for (int i = 0; i < n; i++) {
            int ave = sumN + sumM;
            int diff = sumTarget - ave;
            if (diff == 0) {
                continue;
            }
            if (diff >= 5) {
                // if the difference greater than equal to 5, bump up the current dice to 
                // 6 and add it to sumN
                sumN += 5;
                res[i] = 6;
            } else {
                // We can just use the diff
                sumN += diff;
                res[i] += diff;
            }
        }
        return res;
    }
}

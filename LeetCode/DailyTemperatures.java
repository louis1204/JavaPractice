class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ranges = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int k = i + 1;
            while (k < temperatures.length) {
                if (temperatures[k] > temperatures[i]) {
                    ranges[i] = k - i;
                    break;
                } else if (ranges[k] == 0) {
                    ranges[i] = 0;
                    break;
                } else {
                    k += ranges[k];
                }
            }
        }
        return ranges;
    }
}

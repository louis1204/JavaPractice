class Solution {
    public int findKthPositive(int[] arr, int k) {
        int amountMissing = 0;
        int nextExpected = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != nextExpected) {
                int diff = arr[i] - nextExpected;
                if (amountMissing + diff >= k) {
                    return nextExpected + (k - amountMissing) - 1;
                }
                amountMissing += diff;
                nextExpected = arr[i] + 1;
            } else {
                nextExpected = arr[i] + 1;
            }
        }
        return nextExpected + (k - amountMissing) - 1;
    }
}

class Solution {
    public int minOperations(int n) {
        // 1, 3, 5, 7
        // target = 16/4 = 4
        int increments = 0;
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = 2 * i + 1;
            sum += arr[i];
        }
        int target = sum / n;
        for (int i = 0; i < n; i++) {
            if (arr[i] < target) {
                increments += target - arr[i];
            }
        }
        return increments;
    }
}

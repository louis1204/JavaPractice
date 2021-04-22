class Solution {
    public int missingNumber(int[] arr) {
        int largestDiff = 0;
        int diffLoc = 0;
        if (arr[0] < arr[1]) {
            for (int i = 0; i < arr.length - 1; i++) {
                int diff = arr[i + 1] - arr[i];
                if (diff > largestDiff) {
                    largestDiff = diff;
                    diffLoc = i;
                }
            }
            return arr[diffLoc] + largestDiff / 2;
        } else {
            for (int i = arr.length - 1; i > 0; i--) {
                int diff = arr[i - 1] - arr[i];
                if (diff > largestDiff) {
                    largestDiff = diff;
                    diffLoc = i;
                }
            }
            return arr[diffLoc] + largestDiff / 2;
        }
    }
}

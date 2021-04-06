class Solution {
    public int largestUniqueNumber(int[] A) {
        int[] arr = new int[1001];
        for (int a : A) {
            arr[a]++;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}

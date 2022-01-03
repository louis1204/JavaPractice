class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];
        int[] otherTrustCount = new int[n + 1];
        for (int[] t : trust) {
            otherTrustCount[t[0]]++;
            trustCount[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (otherTrustCount[i] == 0 && trustCount[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}

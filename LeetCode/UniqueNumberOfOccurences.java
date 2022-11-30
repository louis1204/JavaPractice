class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] seen = new int[2001];
        int offset = 1000;
        for (int num : arr) {
            seen[num + offset]++;
        }
        boolean[] seen2 = new boolean[2001];
        for (int s : seen) {
            if (s == 0) {
                continue;
            }
            if (seen2[s]) {
                return false;
            }
            seen2[s] = true;
        }
        return true;
    }
}

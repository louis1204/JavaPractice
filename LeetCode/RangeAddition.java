class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            res[update[0]] += update[2];
            if (update[1] < length - 1) {
                res[update[1] + 1] -= update[2];
            }
        }
        int accum = 0;
        for (int i = 0; i < length; i++) {
            if (res[i] != 0) {
                accum += res[i];
            }
            res[i] = accum;
        }
        return res;
    }
}

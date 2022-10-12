class Solution {
    public int[] findArray(int[] pref) {
        int mask = pref[0];
        for (int i = 1; i < pref.length; i++) {
            int temp = mask ^ pref[i];
            pref[i] = temp;
            mask ^= temp;
        }
        return pref;
    }
}

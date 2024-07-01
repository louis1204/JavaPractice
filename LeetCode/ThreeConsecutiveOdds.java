class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        // Just simulate
        byte bits = 0;
        byte bitMask = 7;
        for (int num : arr) {
            bits <<= 1;
            if (num % 2 != 0) {
                bits |= 1;
                if ((bits & bitMask) == bitMask) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int i = 0;
        while (i++ < 32) {
            if ((n & 1) != 0) {
                res <<= 1;
                res |= 1;
            } else {
                res <<= 1;
            }
            n >>= 1;
        }
        return res;
    }
}

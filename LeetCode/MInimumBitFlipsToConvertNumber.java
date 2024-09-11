class Solution {
    public int minBitFlips(int start, int goal) {
        start = start ^ goal;
        String s = Integer.toBinaryString(start);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }
}

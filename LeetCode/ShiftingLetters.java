class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int accum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i < shifts.length) {
                accum += shifts[i];
                accum %= 26;
            }
            char ch = (char)(s.charAt(i) + accum);
            if (ch > 'z') {
                ch = (char)('a' + (ch - 'z' - 1));
            }
            sb.insert(0, ch);
        }
        return sb.toString();
    }
}

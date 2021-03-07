class Solution {
    public boolean checkOnesSegment(String s) {
        int ptr = 0;
        while (ptr < s.length() && s.charAt(ptr) != '1') {
            ptr++;
        }
        if (ptr == s.length()) {
            return false;
        }
        while (ptr < s.length() && s.charAt(ptr) != '0') {
            ptr++;
        }
        while (ptr < s.length()) {
            if (s.charAt(ptr) == '1') {
                return false;
            }
            ptr++;
        }
        return true;
    }
}

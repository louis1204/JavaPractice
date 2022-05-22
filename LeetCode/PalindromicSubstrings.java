class Solution {
    public int countSubstrings(String s) {
        // Just go through all substrings?
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPal(s.substring(i, j))) {
                    res++;
                }
            }
        }
        return res;
    }
    
    private boolean isPal(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}

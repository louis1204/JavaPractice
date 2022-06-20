class Solution {
    public String greatestLetter(String s) {
        boolean[] doesLowerExists = new boolean[26];
        boolean[] doesUpperExists = new boolean[26];
        
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                doesLowerExists[c - 'a'] = true;
            } else {
                doesUpperExists[c - 'A'] = true;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (doesUpperExists[i] && doesLowerExists[i]) {
                return "" + Character.toUpperCase((char) ('a' + i));
            }
        }
        return "";
    }
}

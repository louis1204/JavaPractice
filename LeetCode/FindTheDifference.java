class Solution {
    public char findTheDifference(String s, String t) {
        int[] temp = new int[26];
        for (char c : s.toCharArray()) {
            temp[c - 'a']--;
        }
        for (char c : t.toCharArray()) {
            temp[c - 'a']++;
            if (temp[c - 'a'] > 0) {
                return c;
            }
        }
        return '\0';
    }
}

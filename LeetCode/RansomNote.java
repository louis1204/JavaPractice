class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ranCount = new int[26];
        int[] magCount = new int[26];
        for (char ch : ransomNote.toCharArray()) {
            ranCount[ch - 'a']++;
        }
        for (char ch : magazine.toCharArray()) {
            magCount[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ranCount[i] > magCount[i]) {
                return false;
            }
        }
        return true;
    }
}

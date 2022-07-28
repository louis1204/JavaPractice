class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        constructMap(sCount, s);
        constructMap(tCount, t);
        return Arrays.equals(sCount, tCount);
    }
    
    private void constructMap(int[] map, String s) {
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }
    }
}

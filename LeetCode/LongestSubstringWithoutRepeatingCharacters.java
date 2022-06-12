class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> letterToPos = new HashMap<>();
        int longest = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            Character c = new Character(s.charAt(j));
            if (letterToPos.containsKey(c)) {
                i = Math.max(letterToPos.get(c), i);
            }
            longest = Math.max(j - i + 1, longest);
            letterToPos.put(c, j + 1);
        }
        return longest;
    }
}
// Sliding window before I knew about sliding window approach

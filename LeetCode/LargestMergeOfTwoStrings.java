class Solution {
    public String largestMerge(String word1, String word2) {
        int ptr1 = 0;
        int ptr2 = 0;
        StringBuilder res = new StringBuilder();
        
        while (ptr1 < word1.length() && ptr2 < word2.length()) {
            char char1 = word1.charAt(ptr1);
            char char2 = word2.charAt(ptr2);
            if (char1 == char2) {
                String s1 = word1.substring(ptr1, word1.length());
                String s2 = word2.substring(ptr2, word2.length());
                if (s1.compareTo(s2) > 0) {
                    res.append(char1);
                    ptr1++;
                    continue;
                } else {
                    res.append(char2);
                    ptr2++;
                    continue;
                }
            }
            if (char1 > char2) {
                res.append(char1);
                ptr1++;
                continue;
            } else {
                res.append(char2);
                ptr2++;
                continue;
            }
        }
        if (ptr1 < word1.length()) {
            res.append(word1.substring(ptr1, word1.length()));
        }
        if (ptr2 < word2.length()) {
            res.append(word2.substring(ptr2, word2.length()));
        }
        return res.toString();
    }
}

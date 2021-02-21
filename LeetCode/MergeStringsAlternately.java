class Solution {
    public String mergeAlternately(String word1, String word2) {
        int ptr1 = 0;
        int ptr2 = 0;
        boolean isPtr1 = true;
        StringBuilder sb = new StringBuilder();
        
        while (ptr1 < word1.length() && ptr2 < word2.length()) {
            if (isPtr1) {
                sb.append(word1.charAt(ptr1++));
            } else {
                sb.append(word2.charAt(ptr2++));
            }
            isPtr1 = !isPtr1;
        }
        if (ptr1 < word1.length()) {
            sb.append(word1.substring(ptr1, word1.length()));
        }
        if (ptr2 < word1.length()) {
            sb.append(word2.substring(ptr2, word2.length()));
        }
        return sb.toString();
    }
}

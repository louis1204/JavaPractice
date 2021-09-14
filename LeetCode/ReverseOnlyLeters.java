class Solution {
    public String reverseOnlyLetters(String s) {
        // 2 ptr approach
        char[] charArr = new char[s.length()];
        StringBuilder sb = new StringBuilder();
        int ptr1 = 0;
        while (ptr1 < charArr.length) {
            if (!isAlpha(s.charAt(ptr1))) {
                charArr[ptr1] = s.charAt(ptr1);
            }
            ptr1++;
        }
        int ptr2 = s.length() - 1;
        ptr1 = 0;
        while (ptr1 < charArr.length) {
            if (charArr[ptr1] != '\u0000') {
                ptr1++;
                continue;
            }
            if (isAlpha(s.charAt(ptr2))) {
                charArr[ptr1] = s.charAt(ptr2);
            }
            ptr2--;
        }
        return new String(charArr);
    }
    
    private boolean isAlpha(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
}

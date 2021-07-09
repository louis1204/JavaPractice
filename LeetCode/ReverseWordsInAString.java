class Solution {
    public void reverseWords(char[] s) {
        // Flip all
        int ptr1 = 0;
        int ptr2 = s.length - 1;
        
        while (ptr1 < ptr2) {
            char temp = s[ptr1];
            s[ptr1] = s[ptr2];
            s[ptr2] = temp;
            ptr1++;
            ptr2--;
        }
        
        int prevLetter = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                swap(s, prevLetter, i - 1);
                prevLetter = i + 1;
            }
        }
        swap(s, prevLetter, s.length - 1);
    }
    
    private void swap(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}

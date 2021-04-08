class Solution {
    public boolean halvesAreAlike(String s) {
        int ptr1 = 0;
        int ptr2 = s.length() / 2;
        int vowelCount1 = 0;
        int vowelCount2 = 0;
        
        while (ptr1 < s.length() / 2) {
            if (isVowel(s.charAt(ptr1++))) {
                vowelCount1++;
            }
            if (isVowel(s.charAt(ptr2++))) {
                vowelCount2++;
            }
        }
        return vowelCount1 == vowelCount2;
    }
    
    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' ||c == 'i' || c == 'o' || c == 'u';
    }
}

class Solution {
    int[] ordering = new int[0];
    public boolean isAlienSorted(String[] words, String order) {
        ordering = new int[order.length()];
        int index = 0;
        for (char c : order.toCharArray()) {
            ordering[c - 'a'] = index++;
        }
        String[] copy = words;
        for (int i = 0; i < words.length - 1; i++) {
            if (!isLessThan(words[i], words[i + 1])) {
                System.out.println(i);
                return false;
            }
        }
        return true;
    }
    
    private boolean isLessThan(String a, String b) {
        int ptr1 = 0;
        int ptr2 = 0;
        while (ptr1 < a.length() && ptr2 < b.length()) {
            int second = ordering[b.charAt(ptr2) - 'a'];
            int first = ordering[a.charAt(ptr1) - 'a'];
            if (second < first) {
                return false;
            } else if (first < second) {
                return true;
            }
            ptr1++;
            ptr2++;
        }
        return ptr1 == a.length();
    }
}

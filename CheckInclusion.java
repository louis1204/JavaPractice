class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Create hashmap of first
        // 2 ptr fixed sliding window on second
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> first = new HashMap<>();
        for (char c : s1.toCharArray()) {
            first.put(c, first.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> second = new HashMap<>();
        int ptr1 = 0;
        int ptr2 = 0;
        // load up
        while (ptr2 < s1.length()) {
            second.put(s2.charAt(ptr2), second.getOrDefault(s2.charAt(ptr2), 0) + 1);
            ptr2++;
        }
        if (second.equals(first)) {
            return true;
        }
        while (ptr2 < s2.length()) {
            second.put(s2.charAt(ptr2), second.getOrDefault(s2.charAt(ptr2), 0) + 1);
            second.put(s2.charAt(ptr1), second.getOrDefault(s2.charAt(ptr1), 1) - 1);
            // System.out.println(second.toString());
            // System.out.println(s2.charAt(ptr1));
            if (second.get(s2.charAt(ptr1)) == 0) {
                second.remove(s2.charAt(ptr1));
            }
            if (second.equals(first)) {
                return true;
            }
            ptr1++;
            ptr2++;
        }
        return false;
    }
}

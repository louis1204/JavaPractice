class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) {
            return 0;
        }
        // sliding window
        // init
        HashMap<Character, Integer> count = new HashMap<>();
        int res = 0;
        for (int i = 0; i < k; i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (isUnique(count)) {
            res++;
        }
        int tail = 0;
        int head = k;
        while (head < s.length()) {
            count.put(s.charAt(tail), count.getOrDefault(s.charAt(tail), 1) - 1);
            count.put(s.charAt(head), count.getOrDefault(s.charAt(head), 0) + 1);
            tail++;
            head++;
            if (isUnique(count)) res++;
        }
        return res;
    }
    
    private boolean isUnique(HashMap<Character, Integer> count) {
        for (int c : count.values()) {
            if (c > 1) {
                return false;
            }
        }
        return true;
    }
}

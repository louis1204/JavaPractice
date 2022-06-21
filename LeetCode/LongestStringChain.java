class Solution {
    public int longestStrChain(String[] words) {
        // We can simulate
        // Can create a graph structure with words to neighs that differ by adding 1 letter
        // For each word, explore the longest chain it can reach and memoize it
        // Return the longest chain
        HashMap<String, Set<String>> neighs = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Set<String> currNeighs = new HashSet<>();
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                String small = words[i].length() <= words[j].length() ? words[i] : words[j];
                String big = words[i].length() > words[j].length() ? words[i] : words[j];
                if (small.equals(words[i]) && isNeigh(small, big)) {
                    currNeighs.add(words[j]);
                }
            }
            neighs.put(words[i], currNeighs);
        }
        System.out.println(neighs);
        HashMap<String, Integer> memo = new HashMap<>();
        int max = 1;
        for (String word : words) {
            max = Math.max(max, helper(word, neighs, memo));
        }
        return max;
    }
    
    private int helper(String word, HashMap<String, Set<String>> neighs, HashMap<String, Integer> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        if (!neighs.containsKey(word)) {
            memo.put(word, 1);
            return 1; // Reached an end
        }
        int max = 0; // Start at one since we count itself
        for (String neigh : neighs.get(word)) {
            max = Math.max(max, helper(neigh, neighs, memo));
        }
        memo.put(word, max + 1);
        return max + 1;
    }
    
    private boolean isNeigh(String s1, String s2) {
        if (s1.length() != s2.length() - 1) {
            return false;
        }
        // Go through each character and allow a difference of 1 in s2
        for (int i = 0, j = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
                continue;
            }
            if (i == j) {
                i--;
                j++;
                continue;
            }
            return false;
        }
        return true;
    }
}

class Solution {
    HashMap<String, Integer> ssCount = new HashMap<>();
    public int findLUSlength(String[] strs) {
        for (String str : strs) {
            helper(str, "", 0);
        }
        int longest = -1;
        for (var entry : ssCount.entrySet()) {
            if (entry.getValue() == 1) {
                longest = Math.max(longest, entry.getKey().length());
            }
        }
        // System.out.println(ssCount.toString());
        return longest;
    }
    
    private void helper(String string, String sub, int start) {
        ssCount.put(sub, ssCount.getOrDefault(sub, 0) + 1);
        if (start >= string.length()) {
            return;
        }
        for (int i = start; i < string.length(); i++) {
            helper(string, sub + string.charAt(i), i + 1);
        }
    }
}

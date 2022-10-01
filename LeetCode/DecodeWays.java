class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
        // Parse past 2 + result from past 2
        // parse 1 + result from past 1
        // add together and set to current
        return helper(s, 0);
    }
    
    private int helper(String s, int index) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (index == s.length() - 1) {
            return 1;
        }
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        int res = helper(s, index + 1);
        int withNext = Integer.parseInt(s.substring(index, index + 2));
        if (withNext > 9 && withNext <= 26) {
            res += helper(s, index + 2);
        }
        memo.put(index, res);
        return res;
    }
}

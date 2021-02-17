class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> letterCasePermutation(String S) {
        helper(S, 0, "");
        return res;
    }
    
    private void helper(String s, int pos, String cons) {
        if (pos == s.length()) {
            res.add(cons);
            return;
        }
        char c = s.charAt(pos);
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            helper(s, pos + 1, cons + Character.toLowerCase(c));
            helper(s, pos + 1, cons + Character.toUpperCase(c));
        } else {
            helper(s, pos + 1, cons + c);
        }
    }
}

class Solution {
    int mod = (int) 1e9 + 7;
    public int countHomogenous(String s) {
        HashMap<String, Integer> counts = new HashMap<>();
        String curr = "";
        for (int i = 0; i < s.length(); i++) {
            if ("".equals(curr) || s.charAt(i) != s.charAt(i - 1)) {
                if (!"".equals(curr)) {
                    counts.put(curr, counts.getOrDefault(curr, 0) + 1);
                    curr = "";
                } 
                
            }
            curr += s.charAt(i);
        }
        if (!"".equals(curr)) {
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
        } 
        int res = 0;
        for (var entry : counts.entrySet()) {
            res += decompose(entry.getKey(), entry.getValue()) % mod;
            res %= mod;
        }
        return res;
    }
    
    private int decompose(String s, int times) {
        int res = 0;
        int len = 1;
        while (len <= s.length()) {
            res += ((s.length() - len + 1) * times) % mod;
            res %= mod;
            len++;
        }
        return res;
    }
}

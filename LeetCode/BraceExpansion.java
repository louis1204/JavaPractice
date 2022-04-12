class Solution {
    public String[] expand(String s) {
        // parse then expand
        List<String[]> parsed = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                int end = i;
                while (s.charAt(end) != '}') {
                    end++;
                }
                parsed.add(s.substring(i + 1, end).split(","));
                i = end;
            } else {
                parsed.add(new String[]{"" + s.charAt(i)});
            }
        }
        // for (String[] s1 : parsed) {
        //     System.out.println(Arrays.toString(s1));
        // }
        List<String> res = new ArrayList<>();
        helper(res, 0, "", parsed);
        res.sort((a, b) -> a.compareTo(b));
        
        String[] actualRes = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            actualRes[i] = res.get(i);
        }
        return actualRes;
    }
    
    private void helper(List<String> res, int ind, String curr, List<String[]> parsed) {
        if (ind >= parsed.size()) {
            res.add(curr);
            return;
        }
        for (String s : parsed.get(ind)) {
            helper(res, ind + 1, curr + s, parsed);
        }
    }
}

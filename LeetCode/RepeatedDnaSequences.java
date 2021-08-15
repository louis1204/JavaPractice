class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Character> nuc = new HashSet<>() {{
            add('A');
            add('C');
            add('G');
            add('T');
        }};
        HashMap<String, Integer> valids = new HashMap<>();
        int ptr2 = 0;
        StringBuilder sb = new StringBuilder();
        
        while (ptr2 < s.length()) {
            char tail = s.charAt(ptr2++);
            if (!nuc.contains(tail)) {
                sb = new StringBuilder();
                continue;
            }
            sb.append(tail);
            if (sb.length() > 10) {
                sb.deleteCharAt(0);
            }
            if (sb.length() == 10) {
                valids.put(sb.toString(), valids.getOrDefault(sb.toString(), 0) + 1);
            }
        }
        
        List<String> res = new ArrayList<>();
        for (var valid : valids.entrySet()) {
            if (valid.getValue() > 1) {
                res.add(valid.getKey());
            }
        }
        return res;
    }
}

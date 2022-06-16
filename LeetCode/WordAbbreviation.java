class Solution {
    public List<String> wordsAbbreviation(List<String> words) {
        // Wasn't able to come up with soln on own, the wording was too confusing
        // Just get all abbreviations starting from the first character
        // If we see the same, then we increment each abbrev in that group by 1
        // Continue until none are the same
        Set<String> seen = new HashSet<>();
        HashMap<String, List<int[]>> tracker = new HashMap<>(); // value is [ind, abbrCount]
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            String abbr = abbr(word, 1);
            List<int[]> existing = tracker.getOrDefault(abbr, new ArrayList<>());
            existing.add(new int[]{i, 1});
            tracker.put(abbr, existing);
        }

        while (tracker.size() != words.size()) {
            HashMap<String, List<int[]>> next = new HashMap<>();
            for (Map.Entry<String, List<int[]>> entry : tracker.entrySet()) {
                List<int[]> abbrs = entry.getValue();
                if (abbrs.size() > 1) {
                    for (int i = 0; i < abbrs.size(); i++) {
                        int[] meta = abbrs.get(i);
                        String abbr = abbr(words.get(meta[0]), meta[1]);
                        List<int[]> existing = next.getOrDefault(abbr, new ArrayList<>());
                        existing.add(new int[]{meta[0], meta[1] + 1});
                        next.put(abbr, existing);
                    }
                    next.remove(entry.getValue());
                } else {
                    next.put(entry.getKey(), entry.getValue());
                }
            }
            tracker = next;
        }
        String[] res = new String[words.size()];
        for (Map.Entry<String, List<int[]>> entry : tracker.entrySet()) {
            int[] meta = entry.getValue().get(0);
            res[meta[0]] = entry.getKey();
        }
        return Arrays.asList(res);
    }
    
    private String abbr(String s, int start) {
        if (s.length() <= 3 || start >= s.length() - 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, start));
        sb.append(s.length() - start - 1);
        sb.append(s.charAt(s.length() - 1));
        return sb.toString();
    }
}

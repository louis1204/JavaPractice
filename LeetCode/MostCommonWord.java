class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> b = new HashSet<>();
        for (String s : banned) {
            b.add(s);
        }
        HashMap<String, Integer> counts = new HashMap<>();
        int top = Integer.MIN_VALUE;
        String resf = null;
        for (String s : paragraph.split(" |\\!|\\?|\\'|\\,|\\;|\\.")) {
            if (s.isEmpty()) {
                continue;
            }
            // StringBuilder sb = new StringBuilder();
            // for (char c : s.toCharArray()) {
            //     if ((c >= 'a' && c <= 'z')
            //       || (c >= 'A' && c <= 'Z')) {
            //         sb.append(c);
            //     }
            // }
            String res = s.toString().toLowerCase();
            if (b.contains(res)) {
                continue;
            }
            counts.put(res, counts.getOrDefault(res, 0) + 1);
            int count = counts.get(res);
            if (count > top) {
                top = count;
                resf = res;
            }
        }
        return resf;
    }
}

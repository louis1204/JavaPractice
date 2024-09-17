class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String s : s1.split(" ")) {
            wordCount.put(s, wordCount.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split(" ")) {
            wordCount.put(s, wordCount.getOrDefault(s, 0) + 1);
        }
        List<String> validStrings = new ArrayList<>();
        for (var entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                validStrings.add(entry.getKey());
            }
        }
        String[] res = new String[validStrings.size()];
        for (int i = 0; i < validStrings.size(); i++) {
            res[i] = validStrings.get(i);
        }
        return res;
    }
}

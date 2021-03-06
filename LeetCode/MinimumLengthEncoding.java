class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        HashMap<String, List<String>> parentToChilds = new HashMap<>();
        for (String word : words) {
            boolean found = false;
            for (var entry : parentToChilds.entrySet()) {
                if (entry.getKey().endsWith(word)) {
                    entry.getValue().add(word);
                    found = true;
                    break;
                }
            }
            if (!found) {
                parentToChilds.put(word, new ArrayList<>());
            }
        }
        int length = 0;
        for (var entry : parentToChilds.entrySet()) {
            length += entry.getKey().length();
        }
        return length + parentToChilds.size();
    }
}

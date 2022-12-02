class Solution {

    public boolean closeStrings(String word1, String word2) {
        HashMap<Character, Integer> word1Count = new HashMap<>();
        HashMap<Character, Integer> word2Count = new HashMap<>();
        for (Character c : word1.toCharArray()) {
            word1Count.put(c, word1Count.getOrDefault(c, 0) + 1);
        }
        for (Character c : word2.toCharArray()) {
            word2Count.put(c, word2Count.getOrDefault(c, 0) + 1);
        }
        if (!word1Count.keySet().equals(word2Count.keySet())) {
            return false;
        }
        List<Integer> l1 = new ArrayList<>();
        l1.addAll(word1Count.values());
        List<Integer> l2 = new ArrayList<>();
        l2.addAll(word2Count.values());
        l1.sort((a, b) -> a - b);
        l2.sort((a, b) -> a - b);
        return l1.equals(l2);
    }
}

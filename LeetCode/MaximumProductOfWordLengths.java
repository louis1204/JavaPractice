class Solution {
    public int maxProduct(String[] words) {
        List<HashSet<Character>> hashes = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < words[i].length(); j++) {
                set.add(words[i].charAt(j));
            }
            hashes.add(set);
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                HashSet<Character> copy = new HashSet<>();
                copy.addAll(hashes.get(i));
                copy.retainAll(hashes.get(j));
                if (copy.isEmpty()) {
                    // System.out.println(words[i]);
                    // System.out.println(words[j]);
                    // System.out.println(words[i].length() * words[j].length());
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}

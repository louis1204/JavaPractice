class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] wordCounts2 = new int[26];
        for (String word : words2) {
            int[] temp = new int[26];
            getCounts(word, temp);
            for (int i = 0; i < 26; i++) {
                wordCounts2[i] = Math.max(wordCounts2[i], temp[i]);
            }
        }
        
        List<String> res = new ArrayList<>();
        
        for (String word : words1) {
            int[] wordCounts1 = new int[26];
            getCounts(word, wordCounts1);
            // For all counts in wordCounts2, check if it's less than or equal to wordCounts1
            boolean allGood = true;
            
            for (int i = 0; i < 26 && allGood; i++) {
                allGood = wordCounts1[i] >= wordCounts2[i];
            }
            if (allGood) {
                res.add(word);
            }
        }
        return res;
    }
    
    private void getCounts(String[] words, int[] wordCounts) {
        for (String word : words) {
            getCounts(word, wordCounts);
        }
    }
    
    private void getCounts(String word, int[] wordCounts) {
        for (char ch : word.toCharArray()) {
            wordCounts[ch - 'a']++;
        }
    }
}

// Wasn't able to come up on own
class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            if (a.length() > b.length()) {
                return -1;
            }
            return 1;
        });
        // Sort is descending order so that the smaller letters comes later
        int wordCounts = 0;
        int wordLengths = 0;
        
        Trie trie = new Trie();
        // System.out.println(Arrays.toString(words));
        for (String word : words) {
            // Go backwards
            Trie curr = trie;
            for (int i = word.length() - 1; i >= 0; i--) {
                int ind = word.charAt(i) - 'a';
                if (i == 0) {
                    if (curr.children[ind] == null) {
                        wordCounts++;
                        wordLengths += word.length();
                    }
                    curr.children[ind] = new Trie();
                } else {
                    if (curr.children[ind] == null) {
                        curr.children[ind] = new Trie();
                    }
                    curr = curr.children[ind];
                }
            }
        }
        // System.out.println(wordCounts);
        // System.out.println(wordLengths);
        return wordCounts + wordLengths;
    }
    
    public class Trie {
        Trie[] children = new Trie[26];
    }
}

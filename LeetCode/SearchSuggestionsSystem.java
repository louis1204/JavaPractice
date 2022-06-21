class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie head = constructTrie(products);
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            char ch = searchWord.charAt(i);
            int ind = ch - 'a';
            if (head.children[ind] == null) {
                while (i < searchWord.length()) {
                    res.add(new ArrayList<>());
                    i++;
                }
                break;
            }
            head = head.children[ind];
            List<String> top3 = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (head.strings.isEmpty()) {
                    break;
                } else {
                    top3.add(head.strings.poll());
                }
            }
            res.add(top3);
        }
        return res;
    }
    
    private Trie constructTrie(String[] products) {
        Trie head = new Trie();
        for (String prod : products) {
            Trie copy = head;
            for (char ch : prod.toCharArray()) {
                int ind = ch - 'a';
                if (copy.children[ind] == null) {
                    copy.children[ind] = new Trie();
                }
                copy = copy.children[ind];
                copy.strings.offer(prod);
            }
        }
        return head;
    }
    private class Trie {
        Trie[] children = new Trie[26];
        PriorityQueue<String> strings = new PriorityQueue<>();
    }
}

class Solution {
    private class Trie {
        HashMap<Character, Trie> children = new HashMap<>();
        Character ch;
        boolean isTerminal;
        Trie parent;
        
        public Trie(Character ch, boolean isTerminal, Trie parent) {
            this.ch = ch;
            this.isTerminal = isTerminal;
            this.parent = parent;
        }
        
        public boolean hasChild(Character ch) {
            return children.containsKey(ch);
        }
        
        public void put(Character ch, boolean isTerminal) {
            if (hasChild(ch)) {
                return;
            }
            children.put(ch, new Trie(ch, isTerminal, this));
        }
        
        public Trie get(Character ch) {
            return children.get(ch);
        }
        
        @Override
        public String toString() {
            return "{ch: " + ch + " terminal: " + isTerminal + " children: " + children.toString() + "}";
        }
    }
    
    HashSet<String> res = new HashSet<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        // Create a trie of the words
        // Go through each square of the board and start exploring DFS with backtracking
        // While exploring, we advance to the next step of the trie if possible, otherwise we stop
        // If we reach the end state of the trie, then we can add that word to a set
        Trie trie = constructTrie(words);
        // System.out.println(trie);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (trie.hasChild(board[i][j])) {
                    explore(board, i, j, trie.get(board[i][j]), new HashSet<>(), "");
                }
            }
        }
        return res.stream().collect(Collectors.toList());
    }
    
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private void explore(
        char[][] board, int i, int j, Trie curr, HashSet<Pair<Integer, Integer>> seen, String s) {
        // Analyze the current word
        s += curr.ch;
        if (curr.isTerminal) {
            res.add(s);
        }
        // Add this to seen
        Pair<Integer, Integer> pair = new Pair<>(i, j);
        seen.add(pair);
        for (int[] dir : dirs) {
            Pair<Integer, Integer> nextPair = new Pair<>(i + dir[0], j + dir[1]);
            if (nextPair.getKey() < 0 || nextPair.getKey() >= board.length || nextPair.getValue() < 0 || nextPair.getValue() >= board[0].length) {
                continue;
            }
            if (seen.contains(nextPair) || !curr.hasChild(board[i + dir[0]][j + dir[1]])) {
                continue;
            }
            explore(board, i + dir[0], j + dir[1], curr.get(board[i + dir[0]][j + dir[1]]), seen, s);
        }
        // Trim off this if there this is a leaf, this is an optimization
        if (curr.children.isEmpty()) {
            curr.parent.children.remove(curr.ch);
        }
        seen.remove(pair);
    }
    
    private Trie constructTrie(String[] words) {
        Trie res = new Trie(null, false, null);
        for (String word : words) {
            char[] charArray = word.toCharArray();
            Trie next = res;
            for (int i = 0; i < charArray.length; i++) {
                if (!next.hasChild(charArray[i])) {
                    next.put(charArray[i], i == charArray.length - 1);
                } else {
                    Trie existing = next.get(charArray[i]);
                    if (i == charArray.length - 1) {
                        existing.isTerminal = true;
                    }
                }
                next = next.get(charArray[i]);
            }
        }
        return res;
    }
}

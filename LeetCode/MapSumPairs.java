class MapSum {
    // Use a trie of letter to sum value
    class Trie {
        HashMap<Character, Trie> children = new HashMap<>();
        Character character;
        int sum = 0;
        
        public Trie(Character c, int sum) {
            this.character = c;
            this.sum = sum;
        }
        
        public Trie getChild(char c) {
            return children.getOrDefault(c, null);
        }
        
        public Trie addChild(Character c, int sum) {
            Trie child = new Trie(c, sum);
            children.put(c, child);
            return child;
        }
        
        public void incrementSum(int add) {
            this.sum += add;
        }
    }
    
    Trie head = new Trie(null, 0);
    HashMap<String, Integer> seen = new HashMap<>();
    
    /** Initialize your data structure here. */
    public MapSum() {}
    
    public void insert(String key, int val) {
        int decVal = seen.getOrDefault(key, 0);
        seen.put(key, val);
        
        List<Trie> queue = new ArrayList<>();
        queue.add(head);
        
        
        for (char c : key.toCharArray()) {
            List<Trie> temp = new ArrayList<>();
            
            while (!queue.isEmpty()) {
                Trie sequence = queue.remove(queue.size() - 1);
                if (sequence.getChild(c) == null) {
                    Trie nextSequence = sequence.addChild(c, val);
                    temp.add(nextSequence);
                } else {
                    Trie nextSequence = sequence.getChild(c);
                    nextSequence.incrementSum(val - decVal);
                    temp.add(nextSequence);
                }
            }
            queue = temp;
        }
    }
    
    public int sum(String prefix) {
        Trie temp = head;
        for (int i = 0; i < prefix.length(); i++) {
            if (temp == null) {
                return 0;
            }
            temp = temp.getChild(prefix.charAt(i));
            if (temp == null) {
                return 0;
            }
            if (i == prefix.length() - 1) {
                return temp.sum;
            }
        }
        return -1;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

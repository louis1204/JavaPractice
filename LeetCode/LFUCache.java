class LFUCache {

    // Create a hashmap for the uses, integer to set of integer
    // Hashmap for the lfu cache will be integer to int[2], first is the value, second is frequency
    HashMap<Integer, LinkedHashSet<Integer>> freqs = new HashMap<>();
    HashMap<Integer, int[]> cache = new HashMap<>();
    int capacity = 0;
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            int[] valFreq = cache.get(key);
            int oldFreq = valFreq[1];
            int val = valFreq[0];
            freqs.get(oldFreq).remove(key);
            LinkedHashSet<Integer> newFreqs = freqs.getOrDefault(oldFreq + 1, new LinkedHashSet<>());
            newFreqs.add(key);
            freqs.put(oldFreq + 1, newFreqs);
            if (freqs.get(oldFreq).isEmpty()) {
                freqs.remove(oldFreq);
            }
            cache.put(key, new int[] {val, oldFreq + 1});
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!cache.containsKey(key) && cache.size() == capacity) {
            // eject
            int leastFreq = Integer.MAX_VALUE;
            for (int freq : freqs.keySet()) {
                leastFreq = Math.min(freq, leastFreq);
            }
            LinkedHashSet<Integer> keys = freqs.get(leastFreq);
            // System.out.println(keys.toString());
            int numToEject = keys.stream().findFirst().get();
            keys.remove(numToEject);
            cache.remove(numToEject);
        }
        if (cache.containsKey(key)) {
            int[] valFreq = cache.get(key);
            int oldFreq = valFreq[1];
            freqs.get(oldFreq).remove(key);
            LinkedHashSet<Integer> newFreqs = freqs.getOrDefault(oldFreq + 1, new LinkedHashSet<>());
            newFreqs.add(key);
            freqs.put(oldFreq + 1, newFreqs);
            if (freqs.get(oldFreq).isEmpty()) {
                freqs.remove(oldFreq);
            }
            cache.put(key, new int[] {value, oldFreq + 1});
        } else {
            cache.put(key, new int[] {value, 1});
            LinkedHashSet<Integer> newFreqs = freqs.getOrDefault(1, new LinkedHashSet<>());
            newFreqs.add(key);
            freqs.put(1, newFreqs);
        }
        // System.out.println(cache.toString());
        // System.out.println(freqs.toString());
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

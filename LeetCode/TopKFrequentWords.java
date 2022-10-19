class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair<String, Integer>> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.getValue() == b.getValue()) {
                return b.getKey().compareTo(a.getKey());
            }
            return a.getValue() - b.getValue();
        });
        HashMap<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            minHeap.offer(new Pair<>(entry.getKey(), entry.getValue()));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(0, minHeap.poll().getKey());
        }
        // res.sort((a, b) -> a.compareTo(b));
        return res;
    }
}

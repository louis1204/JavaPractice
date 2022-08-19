class Solution {
    public boolean isPossible(int[] nums) {
        // Is this a greedy algo?
        // When we see duplicate numbers, then we branch off
        // Append numbers to the smallest chain
        // Return true if all chains are of length >= 3
        // We can optimize by having a HashMap to Heap of lists
        // Key is the last number in the list and the heap is a min heap on size
        HashMap<Integer, PriorityQueue<List<Integer>>> map = new HashMap<>();
        for (int num : nums) {
            PriorityQueue<List<Integer>> newQueue = map.getOrDefault(num, new PriorityQueue<>((a, b) -> a.size() - b.size()));
            if (!map.containsKey(num - 1) || map.get(num - 1).isEmpty()) {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                newQueue.offer(list);
                map.put(num, newQueue);
            } else {
                List<Integer> list = map.get(num - 1).poll();
                list.add(num);
                newQueue.offer(list);
                map.put(num, newQueue);
            }
            // System.out.println(map.toString());
        }
        for (var entry : map.entrySet()) {
            while (!entry.getValue().isEmpty()) {
                int size = entry.getValue().poll().size();
                if (size > 0 && size < 3) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Just use a heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            heap.offer(stone);
        }
        while (heap.size() > 1) {
            int hi = heap.poll();
            int lo = heap.size() > 0 ? heap.poll() : hi;
            int newWeight = hi - lo;
            if (newWeight > 0) {
                heap.offer(newWeight);
            }
        }
        return heap.isEmpty() ? 0 : heap.poll();
    }
}

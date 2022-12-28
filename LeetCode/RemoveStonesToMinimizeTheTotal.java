class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int p : piles) {
            maxHeap.offer(p);
        }
        for (int i = 0; i < k; i++) {
            int top = maxHeap.poll();
            top -= top / 2;
            maxHeap.offer(top);
        }
        int res = 0;
        while (!maxHeap.isEmpty()) {
            res += maxHeap.poll();
        }
        return res;
    }
}

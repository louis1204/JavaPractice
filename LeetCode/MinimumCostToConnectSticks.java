class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int res = 0;
        for (int i = 0; i < sticks.length; i++) {
            minHeap.offer(sticks[i]);
        }
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int newStick = first + second;
            res += newStick;
            minHeap.offer(newStick);
        }
        return res;
    }
}

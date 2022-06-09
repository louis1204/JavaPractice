class Solution {
    public int minMaxGame(int[] nums) {
        // Simulate? We can use a queue and alternate from min and max until the queue is size 1
        Deque<Integer> queue = new LinkedList<>();
        for (int num : nums) {
            queue.offer(num);
        }
        while (queue.size() > 1) {
            Deque<Integer> next = new LinkedList<>();
            boolean isMin = true;
            while (!queue.isEmpty()) {
                int a = queue.poll();
                int b = queue.poll();
                if (isMin) {
                    next.offer(Math.min(a, b));
                } else {
                    next.offer(Math.max(a, b));
                }
                isMin = !isMin;
            }
            queue = next;
        }
        return queue.poll();
    }
}

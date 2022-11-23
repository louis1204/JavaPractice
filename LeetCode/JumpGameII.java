class Solution {
    public int jump(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        seen[0] = true;

        Deque<int[]> queue = new LinkedList<>(); // ind, jumps
        // PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]); // ind, jumps
        queue.offer(new int[] {0, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int ind = curr[0];
            int jumps = curr[1];
            if (ind == nums.length - 1) {
                return jumps;
            }
            for (int i = 1; i <= nums[ind] && i + ind < nums.length; i++) {
                if (!seen[i + ind]) {
                    queue.offer(new int[] {ind + i, jumps + 1});
                    seen[i + ind] = true;
                }
            }
        }
        return -1; // Shouldn't reach
    }
}

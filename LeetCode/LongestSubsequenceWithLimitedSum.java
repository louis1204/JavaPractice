class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] max = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            max[i] = helper(nums, q);
        }
        return max;
    }

    // Use a max heap and remove the previous large one if we go over the limit
    private int helper(int[] nums, int max) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int curr = 0;
        for (int num : nums) {
            if (curr + num <= max) {
                maxHeap.offer(num);
                curr += num;
                continue;
            } else if (!maxHeap.isEmpty() && curr + num - maxHeap.peek() < curr) {
                int currMax = maxHeap.poll();
                maxHeap.offer(num);
                curr = curr - currMax + num;
            }
        }
        return maxHeap.size();
    }
}

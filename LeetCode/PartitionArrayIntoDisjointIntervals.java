class Solution {
    public int partitionDisjoint(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        maxHeap.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }
        
        if (maxHeap.peek() <= minHeap.peek()) {
            return 1;
        }
        // System.out.println(maxHeap.toString());
        //         System.out.println(minHeap.toString());
        for (int i = 1; i < nums.length - 1; i++) {
            maxHeap.add(nums[i]);
            minHeap.remove(nums[i]);
            if (maxHeap.peek() <= minHeap.peek()) {
                // System.out.println(maxHeap.toString());
                // System.out.println(minHeap.toString());
                return maxHeap.size();
            }
        }
        // Shouldn't reach this
        return -1;
    }
}

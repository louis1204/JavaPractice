class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Can't brute force or simulate given the problem space
        // Can we simulate with a memo?
        // If we simulate at each height, if the next is greater, save the store the furthest you can go
        // with the current bricks, ladders, at the current position
        // Now the possibilities is bricks * ladders * heights, which is too much
        
        // Can we approach this greedily? We should always use ladders for the tallest buildings
        // and leave the bricks for the smallest ones
        // We can iteratively do this
        // Then when we approach a new building, we ask which pile it would have been in?
        
        // The number of ladders is fixed actually, so we want the biggest ladders to use that
        // and when we run out of ladders, we eject it out of the heap and use bricks to build
        
        // If we don't have enough bricks for it then that's the end of the road
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Math.max(1, ladders));
        int i = 0;
        for (; i < heights.length - 1; i++) { // Go up to length - 1, since we don't need to eval the end
            if (heights[i + 1] > heights[i]) {
                // Check if we need to eject
                int diff = heights[i + 1] - heights[i];
                if (ladders != 0 && minHeap.size() == ladders && diff > minHeap.peek()) {
                    bricks -= minHeap.poll();
                    minHeap.offer(diff);
                } else if (minHeap.size() == ladders) {
                    bricks -= diff;
                } else {
                    minHeap.offer(diff);
                }
            }
            if (bricks < 0) {
                break;
            }
        }
        return i;
    }
}

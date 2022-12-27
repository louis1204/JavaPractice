class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        // Sort by smallest available space.
        // Greedy approach
        List<Integer> space = new ArrayList<>();
        for (int i = 0; i < rocks.length; i++) {
            space.add(capacity[i] - rocks[i]);
        }
        space.sort((a, b) -> a - b);
        int maxBags = 0;
        for (int s : space) {
            additionalRocks -= s;
            if (additionalRocks >= 0) {
                maxBags++;
            } else {
                break;
            }
        }
        return maxBags;
    }
}

class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<Pair<Integer, Integer>> nextSmallestCost =
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        // Initialize with wells
        for (int i = 0; i < wells.length; i++) {
            nextSmallestCost.add(new Pair<>(i + 1, wells[i]));
        }
        
        List<List<Pair<Integer, Integer>>> edges = new ArrayList<>(); // [[next node, cost]]
        // Initialize
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        // add the edges
        for (int[] pipe : pipes) {
            edges.get(pipe[0] - 1).add(new Pair<>(pipe[1], pipe[2]));
            edges.get(pipe[1] - 1).add(new Pair<>(pipe[0], pipe[2]));
        }
        Set<Integer> seen = new HashSet<>();
        
        int cost = 0;
        while (seen.size() < n) {
            Pair<Integer, Integer> next = nextSmallestCost.poll();
            if (seen.contains(next.getKey())) {
                continue;
            }
            cost += next.getValue();
            seen.add(next.getKey());
            for (Pair<Integer, Integer> edge : edges.get(next.getKey() - 1)) {
                nextSmallestCost.add(edge);
            }
        }
        return cost;
    }
}

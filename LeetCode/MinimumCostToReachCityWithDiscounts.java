class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {
        // We can use djik to find the shortest distance to the end
        // We can use djik to construct the path there, afterwards we can 
        // greedily find the n biggest tolls and apply our discounts
        // Keep track of the discounts state in the djik instead, then update if we can divide
        // At each evaluation we can either take the discount if we can or not. Do both
        int[][] djik = new int[discounts + 1][n]; // Amount of discounts left, terminal n
        for (int[] row : djik)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]); // node, cost, discounts
        // set up neighbors
        HashMap<Integer, List<int[]>> neighs = new HashMap<>();
        for (int[] highway : highways) {
            List<int[]> existing = neighs.getOrDefault(highway[0], new ArrayList<>());
            existing.add(new int[] {highway[1], highway[2]});
            neighs.put(highway[0], existing);
            
            existing = neighs.getOrDefault(highway[1], new ArrayList<>());
            existing.add(new int[] {highway[0], highway[2]});
            neighs.put(highway[1], existing);
        }
        djik[discounts][0] = 0;
        heap.offer(new int[] {0, 0, discounts});
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            if (curr[0] == n - 1) {
                return curr[1];
            }
            for (int[] neigh : neighs.getOrDefault(curr[0], new ArrayList<>())) {
                int costThroughCurr = djik[curr[2]][curr[0]] + neigh[1];
                int costThroughCurrWithDiscount = djik[curr[2]][curr[0]] + neigh[1] / 2;
                // No discount
                if (costThroughCurr < djik[curr[2]][neigh[0]]) {
                    djik[curr[2]][neigh[0]] = costThroughCurr;
                    heap.offer(new int[]{neigh[0], costThroughCurr, curr[2]});
                }
                // Discount
                if (curr[2] > 0 && costThroughCurrWithDiscount <  djik[curr[2] - 1][neigh[0]]) {
                    djik[curr[2] - 1][neigh[0]] = costThroughCurrWithDiscount;
                    heap.offer(new int[]{neigh[0], costThroughCurrWithDiscount, curr[2] - 1});
                }
            }
        }
        return -1;
    }
}

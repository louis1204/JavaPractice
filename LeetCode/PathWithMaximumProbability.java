class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] prob = new double[n];
        prob[start] = 1.0;
        HashMap<Set<Integer>, Double> pairToProb = new HashMap<>();
        HashMap<Integer, Set<Integer>> nodeToNeigh = new HashMap<>();
        
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            Set<Integer> key = new HashSet<>();
            key.add(edge[0]);
            key.add(edge[1]);
            pairToProb.put(key, succProb[i]);
            
            Set<Integer> existing = nodeToNeigh.getOrDefault(edge[0], new HashSet<>());
            existing.add(edge[1]);
            nodeToNeigh.put(edge[0], existing);
            
            existing = nodeToNeigh.getOrDefault(edge[1], new HashSet<>());
            existing.add(edge[0]);
            nodeToNeigh.put(edge[1], existing);
        }
        Deque<Integer> queue = new LinkedList<>(); // nodes
        queue.offer(start);
        while (!queue.isEmpty()) {
            int curr = queue.pop();
            for (int neigh : nodeToNeigh.getOrDefault(curr, new HashSet<>())) {
                Set<Integer> key = new HashSet<>();
                key.add(neigh);
                key.add(curr);

                double probThroughCurr = prob[curr] * pairToProb.get(key);
                if (probThroughCurr > prob[neigh]) {
                    prob[neigh] = probThroughCurr;
                    queue.offer(neigh);
                }
            }
        }
        return prob[end];
    }
}

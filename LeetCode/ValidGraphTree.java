class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Keep a set of seen nodes
        // Keep an integer array of levels
        // If the prevailing node is seen, check that the next's level is prevailing level + 1
        // Otherwise return false
        if (n <= 1) {
            return true;
        }
        if (edges.length == 0) {
            return false;
        }
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int lo = Math.min(edge[0], edge[1]);
            int hi = Math.max(edge[0], edge[1]);
            List<Integer> existing = graph.getOrDefault(lo, new ArrayList<>());
            existing.add(hi);
            graph.put(lo, existing);
            
            existing = graph.getOrDefault(hi, new ArrayList<>());
            existing.add(lo);
            graph.put(hi, existing);
        }
        System.out.println(graph.toString());
        Set<Integer> seen = new HashSet<>();
        Integer start = graph.entrySet().iterator().next().getKey();
        List<Integer> next = new ArrayList<>();
        next.add(start);
        int level = 1;
        int[] levels = new int[n];
        while (!next.isEmpty()) {
            
            List<Integer> temp = new ArrayList<>();
            for (Integer node : next) {
                if (seen.contains(node)) {
                    if (levels[node] != level - 1) {
                        // System.out.println(seen.toString());
                        // System.out.println(node);
                        // System.out.println(Arrays.toString(levels));
                        return false;
                    }
                    continue;
                } else {
                    levels[node] = level;
                    seen.add(node);
                }
                for (Integer nodeChild : graph.getOrDefault(node, new ArrayList<>())) {
                    if (seen.contains(nodeChild)) {
                        if (levels[nodeChild] != level - 1) {
                            return false;
                        }
                    } else {
                        temp.add(nodeChild);
                    }
                }
            }
            seen.addAll(next);
            next = temp;
            level++;
        }
        return seen.size() == n;
    }
}

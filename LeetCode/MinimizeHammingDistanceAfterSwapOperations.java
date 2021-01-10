class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        // Get possible indices for each index. If it's only self add 1 if different
        // Check if where it should be is in the the possible indices
        HashMap<Integer, Integer> targetPos = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            targetPos.put(target[i], i);
        }
        int[] unionFind = new int[target.length];
        for (int i = 0; i < unionFind.length; i++) {
            unionFind[i] = i;
        }
        for (int[] swap : allowedSwaps) {
            int parent1 = getParent(swap[0], unionFind);
            int parent2 = getParent(swap[1], unionFind);
            if (parent1 != parent2) {
                unionFind[parent1] = parent2;
            }
        }
        // HashMap<Integer, Set<Integer>> parentToNodes = new HashMap<>(); // parent to all pos it can go to
        // for (int i = 0; i < source.length; i++) {
        //     int parent = getParent(i, unionFind);
        //     Set<Integer> existing = parentToNodes.getOrDefault(parent, new HashSet<>());
        //     existing.add(i);
        //     parentToNodes.put(parent, existing);
        // }
        HashMap<Pair<Integer, Integer>, Integer> counts = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            int par = getParent(i, unionFind);
            Pair<Integer, Integer> src = new Pair<>(par, source[i]);
            Pair<Integer, Integer> tgt = new Pair<>(par, target[i]);
            counts.put(src, counts.getOrDefault(src, 0) + 1);
            counts.put(tgt, counts.getOrDefault(tgt, 0) - 1);
        }

        int res = 0;
        for (var entry : counts.entrySet()) {
            if (entry.getValue() > 0) {
                res += entry.getValue();
            }
        }
        return res;
    }
    
    private int getParent(int node, int[] unionFind) {
        if (unionFind[node] == node) {
            return node;
        }
        int parent = getParent(unionFind[node], unionFind);
        unionFind[node] = parent;
        return parent;
    }
}

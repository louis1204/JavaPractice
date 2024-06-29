class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Find all the nodes that don't have vectors going into them
        // Create hashmap of node to neigh
        // Starting at each root node, dfs until you hit a leaf
        // As you dfs, pass down all that we've seen so we can add them all to the result

        // We can actually reverse the arrows and start from the leafs instead
        // This way, if we encounter an already seen node, we just return the cached value
        int[] inCount = new int[n];
        HashMap<Integer, List<Integer>> neighs = new HashMap<>();
        for (int[] edge : edges) {
            inCount[edge[0]]++;
            List<Integer> existing = neighs.getOrDefault(edge[1], new ArrayList<>());
            existing.add(edge[0]);
            neighs.put(edge[1], existing);
        }
        List<HashSet<Integer>> resSets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            resSets.add(new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            if (inCount[i] == 0) {
                dfs(resSets, i, neighs);
            }
        }
        // create the res
        List<List<Integer>> res = new ArrayList<>();
        for (HashSet<Integer> resSet : resSets) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(resSet);
            temp.sort((a, b) -> a - b);
            res.add(temp);
        }
        return res;
    }

    private HashSet<Integer> dfs(List<HashSet<Integer>> resSets, int currNode, HashMap<Integer, List<Integer>> neighs) {
        // At the end
        if (!neighs.containsKey(currNode)) {
            HashSet<Integer> set = new HashSet<>();
            set.add(currNode);
            return set;
        }
        // Go over neighs. If we already explored it, just add the current parents and the neigh, ow dfs
        for (Integer neigh : neighs.get(currNode)) {
            if (!resSets.get(neigh).isEmpty()) {
                resSets.get(currNode).addAll(resSets.get(neigh));
                resSets.get(currNode).add(neigh);
            } else {
                resSets.get(currNode).addAll(dfs(resSets, neigh, neighs));
                resSets.get(currNode).add(neigh);
            }
        }
        return resSets.get(currNode);
    }
}

class Solution {
    public int numberOfPatterns(int m, int n) {
        // Simulate?
        // At each place we need to know all reachable nodes
        // The only restriction is that we can reach a node where we'd go through the center of a
        // non consumed node
        // At each state, find all reachable nodes?
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Pair<Integer, Integer> curr = new Pair<>(i, j);
                HashSet<Pair<Integer, Integer>> seen = new HashSet<>();
                seen.add(curr);
                findNumberOfWays(i, j, seen, m, n, 1);
            }
        }
        return res;
    }
    int res = 0;
    
    private void findNumberOfWays(int i, int j, HashSet<Pair<Integer, Integer>> seen, int m, int n, int count) {
        if (count >= m) {
            res += 1;
        }
        if (count == n) {
            return;
        }
        List<Pair<Integer, Integer>> reachableNodes = getReachableNodes(seen, i , j);
        // System.out.println(reachableNodes);
        int res = 0;
        for (Pair<Integer, Integer> node : reachableNodes) {
            seen.add(node);
            findNumberOfWays(node.getKey(), node.getValue(), seen, m, n, count + 1);
        }
    }
    
    private List<Pair<Integer, Integer>> getReachableNodes(HashSet<Pair<Integer, Integer>> seen, int i, int j) {
        List<Pair<Integer, Integer>> res = new ArrayList<>();
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                Pair<Integer, Integer> curr = new Pair<>(m, n);
                if (seen.contains(curr)) {
                    continue;
                }
                if (isReachable(curr, i, j, seen)) {
                    res.add(curr);
                }
            }
        }
        return res;
    }
    
    private boolean isReachable(Pair<Integer, Integer> curr, int i, int j, HashSet<Pair<Integer, Integer>> seen) {
        // A few things to check
        int iDiff = Math.abs(curr.getKey() - i);
        int jDiff = Math.abs(curr.getValue() - j);

        // If on the same axis and not a difference of one, we have to check if the intermediate is seen yet
        if (curr.getKey() == i && curr.getValue() != j) {
            if (jDiff != 1) {
                return seen.contains(new Pair<>(i, Math.min(curr.getValue(), j) + 1));
            }
            return true;
        }
        if (curr.getValue() == j && curr.getKey() != i) {
            if (iDiff != 1) {
                return seen.contains(new Pair<>(Math.min(curr.getKey(), i) + 1, j));
            }
            return true;
        }
        
        // If on a diagonal and not a difference of one, we have to check if the intermediate is seen yet
        if (iDiff == 1 && jDiff == 1) {
            return true;
        }
        if (iDiff == jDiff) {
            // int inBetween = (curr.getKey() + i) / 2;
            if (seen.contains(new Pair<>(1, 1))) {
                return true;
            }
            return false;
        }
        // If the difference is unequal it should be fine since we won't be stepping
        return iDiff != jDiff;
    }
}

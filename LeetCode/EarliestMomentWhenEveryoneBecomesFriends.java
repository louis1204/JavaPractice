class Solution {
    public int earliestAcq(int[][] logs, int n) {
        // Can use union find and see if all has the same parent
        int[] unionFind = new int[n];
        for (int i = 0; i < n; i++) {
            unionFind[i] = i;
        }
        
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        
        for (int[] log : logs) {
            int a = log[1], b = log[2];
            int aParent = find(a, unionFind);
            int bParent = find(b, unionFind);
            unionFind[aParent] = bParent;
            if (hasOnlyOneComp(unionFind)) {
                return log[0];
            }
        }
        return -1;
    }
    
    private int find(int node, int[] unionFind) {
        if (node == unionFind[node]) {
            return node;
        }
        int parent = find(unionFind[node], unionFind);
        unionFind[node] = parent;
        return parent;
    }
    
    private boolean hasOnlyOneComp(int[] unionFind) {
        Set<Integer> seen = new HashSet<>();
        for (int x : unionFind) {
            seen.add(find(x, unionFind));
            if (seen.size() > 1) {
                return false;
            }
        }
        return true;
    }
}

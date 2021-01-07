class Solution {
    public int findCircleNum(int[][] isConnected) {
        // union find
        int[] unionFind = new int[isConnected.length];
        for (int i = 0; i < unionFind.length; i++) {
            unionFind[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    int parent1 = getParent(i, unionFind);
                    int parent2 = getParent(j, unionFind);
                    if (parent1 != parent2) {
                        unionFind[parent1] = parent2;
                    }
                }
            }
        }
        Set<Integer> seen = new HashSet<>();
        int res = 0;
        for (int i = 0; i < unionFind.length; i++) {
            if (seen.add(getParent(i, unionFind))) {
                res++;
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

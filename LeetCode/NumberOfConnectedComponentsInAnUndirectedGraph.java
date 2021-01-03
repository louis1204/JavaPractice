class Solution {
    public int countComponents(int n, int[][] edges) {
        // Can do union find
        int[] unionFind = new int[n];
        for (int i = 0; i < n; i++) {
            unionFind[i] = i;
        }
        for (int[] edge : edges) {
            int leftParent = getParent(edge[0], unionFind);
            int rightParent = getParent(edge[1], unionFind);
            if (leftParent != rightParent) {
                unionFind[rightParent] = leftParent;
            }
            // System.out.println(Arrays.toString(unionFind));
        }
        Set<Integer> components = new HashSet<>();
        for (int i = 0; i < n; i++) {
            components.add(getParent(i, unionFind));
        }
        // System.out.println(components.toString());
        // System.out.println(Arrays.toString(unionFind));
        return components.size();
    }
    
    private int getParent(int node, int[] unionFind) {
        if (unionFind[node] != node) {
            int actualParent = getParent(unionFind[node], unionFind);
            unionFind[node] = actualParent;
        }
        return unionFind[node];
    }
}

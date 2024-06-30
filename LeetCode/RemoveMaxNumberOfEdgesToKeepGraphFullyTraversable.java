class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // Use union find for alice and bob
        // Use type 3 edges first then use others
        int[] aDSU = new int[n + 1];
        int[] bDSU = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 0; i < n; i++) {
            aDSU[i + 1] = i + 1;
            bDSU[i + 1] = i + 1;
        }
        int edgesUsed = 0;
        // Process blue edges
        // System.out.println(Arrays.toString(aDSU));
        for (int[] edge: edges) {
            if (edge[0] == 3) {
                if (hasJoined(edge, aDSU, rank)) {
                    hasJoined(edge, bDSU, rank); // if it joined for alice, it must join for bob too
                    edgesUsed++;
                    // System.out.println("Edge used: " + Arrays.toString(edge));
                }
                        // System.out.println(Arrays.toString(aDSU));
            }
        }
        // Process alice edges
        for (int[] edge: edges) {
            if (edge[0] == 1) {
                if (hasJoined(edge, aDSU, rank)) {
                    edgesUsed++;
                    // System.out.println("Edge used for a: " + Arrays.toString(edge));
                }
            } else if (edge[0] == 2) {
                if (hasJoined(edge, bDSU, rank)) {
                    edgesUsed++;
                    // System.out.println("Edge used for b: " + Arrays.toString(edge));
                }
            }
        }
        // System.out.println(Arrays.toString(aDSU));
        // System.out.println(Arrays.toString(bDSU));
        // System.out.println(n - edgesUsed);
        return allConnected(aDSU) && allConnected(bDSU) ? edges.length - edgesUsed : -1;
    }

    private boolean hasJoined(int[] edge, int[] dsu, int[] rank) {
        if (find(dsu, edge[1]) != find(dsu, edge[2])) {
            // we can join
            union(edge, dsu, rank);
            return true;
        }
        // Already joined
        return false;
    }

    private void union(int[] edge, int[] dsu, int[] rank) {
        int a = find(dsu, edge[1]);
        int b = find(dsu, edge[2]);
        if (rank[a] > rank[b]) {
            dsu[b] = a;
        } else if (rank[b] > rank[a]) {
            dsu[a] = b;
        } else {
            dsu[b] = a;
            rank[a]++;
        }
    }

    private int find(int[] dsu, int curr) {
        if (dsu[curr] == curr) {
            return curr;
        }
        int parent = find(dsu, dsu[curr]);
        // dsu[curr] = parent;
        return parent;
    }

    private boolean allConnected(int[] dsu) {
        int parent = -1;
        for (int i = 1; i < dsu.length; i++) {
            int temp = find(dsu, dsu[i]);
            if (parent == -1) {
                parent = temp;
                continue;
            }
            if (parent != temp) {
                return false;
            }
        }
        return true;
    }
}

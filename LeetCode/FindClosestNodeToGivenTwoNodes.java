class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        // Build a relationship list
        // has the distance from the node1
        // Build a distance map for node2 and get the min of dist to node2 + dist to node 1, save the index of that shortest dist node
        // System.out.println(Arrays.toString(edges));
        // int[] temp = new int[edges.length];
        // for (int i = 0; i < edges.length; i++) {
        //     temp[i] = i;
        // }
        // System.out.println(Arrays.toString(temp));
        int[] distNode1 = new int[edges.length];
        Arrays.fill(distNode1, -1);
        int[] distNode2 = new int[edges.length];
        Arrays.fill(distNode2, -1);
        buildDist(distNode1, node1, edges);
        buildDist(distNode2, node2, edges);
        // System.out.println(Arrays.toString(distNode1));
        // System.out.println(Arrays.toString(distNode2));
        int smallestNode = -1;
        int smallestDist = Integer.MAX_VALUE;
        for (int i = 0; i < distNode1.length; i++) {
            if (distNode1[i] < 0 || distNode2[i] < 0) {
                continue;
            }
            int dist = Math.max(distNode1[i], distNode2[i]);
            // System.out.println("i=" + i + " dist=" + dist);
            if (dist < smallestDist) {
                smallestDist = dist;
                smallestNode = i;
            }
        }
        return smallestNode;
    }

    private void buildDist(int[] distNode, int node, int[] edges) {
        int distance = 0;
        while (node != -1 && distNode[node] < 0) {
            distNode[node] = distance++;
            node = edges[node];
        } 
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node> cache = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node clone = null;
        if (cache.containsKey(node.val)) {
            clone = cache.get(node.val);
            return clone;
        } else {
            clone = new Node(node.val);
        }
        cache.put(node.val, clone);
        ArrayList<Node> neighClone = new ArrayList<>();
        for (Node neigh : node.neighbors) {
            neighClone.add(cloneGraph(neigh));
        }
        clone.neighbors = neighClone;
        return clone;
    }
}

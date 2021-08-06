/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // Just bfs
        List<Node> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Node> next = new ArrayList<>();
            List<Integer> prev = new ArrayList<>();
            
            for (Node node : queue) {
                prev.add(node.val);
                for (Node child : node.children) {
                    if (child != null) {
                        next.add(child);
                    }
                }
            }
            res.add(prev);
            queue = next;
        }
        return res;
    }
}

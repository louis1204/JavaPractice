/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        // Just get the min less than of the parent branch if right is null
        Node parent = helperParent(node.parent, node.val);
        if (node.right == null) {
            return parent == null || parent.val > node.val ? parent : null;
        }
        // Otherwise, get the min of the right branch
        Node minRight = helper(node.right);
        return minRight.val == node.val ? null : minRight;
    }
    
    public Node helperParent(Node node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val > val) {
            return node;
        }
        return helperParent(node.parent, val);
    }
    
    public Node helper(Node node) {
        if (node.left == null) {
            return node;
        }
        return helper(node.left);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        // Looks like we have to be a bit greedy on filling in each level
        // Continuosly get the middle?
        List<TreeNode> inOrder = new ArrayList<>();
        getInOrder(root, inOrder);

        // Recursively create the new BST
        return balance(inOrder, 0, inOrder.size());
    }

    private void getInOrder(TreeNode node, List<TreeNode> inOrder) {
        if (node == null) {
            return;
        }
        getInOrder(node.left, inOrder);
        inOrder.add(node);
        getInOrder(node.right, inOrder);
    }

    private TreeNode balance(List<TreeNode> inOrder, int head, int tail) {
        if (head > tail || head == inOrder.size()) {
            // Reached out of bounds
            return null;
        }
        if (head == tail) {
            // Reached the end
            inOrder.get(head).left = null;
            inOrder.get(head).right = null; 
            return inOrder.get(head);
        }
        
        int mid = (head + tail) / 2;
        TreeNode midNode = inOrder.get(mid);
        midNode.left = balance(inOrder, head, mid - 1);
        midNode.right = balance(inOrder, mid + 1, tail);
        return midNode;
    }
}

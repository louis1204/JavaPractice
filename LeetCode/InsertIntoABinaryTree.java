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
    boolean isSet = false;
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        helper(root, val);
        return root;
    }
    
    private void helper(TreeNode node, int val) {
        if (node == null | isSet) {
            return;
        }
        if (node.left == null && val < node.val) {
            node.left = new TreeNode(val);
            isSet = true;
            return;
        }
        if (node.right == null && val > node.val) {
            node.right = new TreeNode(val);
            isSet = true;
            return;
        }
        if (val < node.val) {
            helper(node.left, val);
        } else {
            helper(node.right, val);
        }
    }
}

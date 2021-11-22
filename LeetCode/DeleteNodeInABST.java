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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            TreeNode rootRight = root.right;
            // Add this subtree to left's most right
            if (root.left == null) {
                return rootRight;
            }
            helper(root.left, rootRight);
            return root.left;
        } else {
            root.left = deleteNode(root.left, key);
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    
    private void helper(TreeNode node, TreeNode rightSubTree) {
        if (node.right == null) {
            node.right = rightSubTree;
        } else {
            helper(node.right, rightSubTree);
        }
    }
}

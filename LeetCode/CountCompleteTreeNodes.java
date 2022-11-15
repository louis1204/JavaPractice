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
    public int countNodes(TreeNode root) {
        // Find the height of the left and right subtrees by going down the left branch
        // After that, if the left subtree is bigger we explore left, otherwise we explore right
        // We do this continually until we hit the leaf
        // log n * log n
        if (root == null) {
            return 0;
        }
        return helper(root, 1);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getHeight(node.left);
    }

    public int helper(TreeNode node, int count) {
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        
        if (leftHeight == 0 && rightHeight == 0) {
            return count;
        }

        if (leftHeight > rightHeight) {
            return helper(node.left, 2 * count);
        }
        return helper(node.right, 2 * count + 1);
    }
}

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
    public TreeNode pruneTree(TreeNode root) {
        if (containsOne(root))
            return root;
        return null;
    }
    
    private boolean containsOne(TreeNode node) {
        if (node == null) {
            return false;
        }
        // if (node.val == 1) {
        //     containsOne(node.left);
        //     containsOne(node.right);
        //     return true;
        // }
        boolean leftHasOne = containsOne(node.left);
        boolean rightHasOne = containsOne(node.right);
        if (!leftHasOne) {
            node.left = null;
        }
        if (!rightHasOne) {
            node.right = null;
        }
        return node.val == 1 || leftHasOne || rightHasOne;
    }
}

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
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return "" + root.val;
        }
        String left = "" + root.val;

        left += "(" + tree2str(root.left);
        left += ")";
        
        String right = tree2str(root.right);
        if (!right.isEmpty()) {
            left += "(" + right;
            left += ")";
        }
        return left;
    }
}

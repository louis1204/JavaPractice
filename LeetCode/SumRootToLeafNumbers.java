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
    int res = 0;
    
    public int sumNumbers(TreeNode root) {
        helper(root, "");
        return res;
    }
    
    private void helper(TreeNode node, String string) {
        if (node.left == null && node.right == null) {
            res += Integer.parseInt(string + node.val);
            return;
        }
        if (node.left != null) {
            helper(node.left, string + node.val);
        }
        if (node.right != null) {
            helper(node.right, string + node.val);
        }
    }
}

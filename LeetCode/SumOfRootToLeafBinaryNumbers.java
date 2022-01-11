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
    
    public int sumRootToLeaf(TreeNode root) {
        helper(root, "");
        return res;
    }
    
    private void helper(TreeNode curr, String sum) {
        if (curr.left == null && curr.right == null) {
            res += Integer.parseInt(sum + curr.val, 2);
            return;
        }
        if (curr.left != null) {
            helper(curr.left, sum + curr.val);
        }
        if (curr.right != null) {
            helper(curr.right, sum + curr.val);
        }
    }
}

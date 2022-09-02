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
    int max = Integer.MIN_VALUE;
    
    public int longestConsecutive(TreeNode root) {
        helper(root.val, 1, root.left);
        helper(root.val, 1, root.right);
        return max;
    }
    
    private void helper(int prev, int count, TreeNode curr) {
        max = Math.max(count, max);
        if (curr == null) {
            return;
        }
        helper(curr.val, curr.val == prev + 1 ? count + 1 : 1, curr.left);
        helper(curr.val, curr.val == prev + 1 ? count + 1 : 1, curr.right);
    }
}

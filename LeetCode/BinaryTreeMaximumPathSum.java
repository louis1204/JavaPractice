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
    
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }
    
    private int getMax(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(getMax(node.left), 0); // Take the left sub branch if it's non neg
        int right = Math.max(getMax(node.right), 0); // Take the right sub branch if it's non neg
        max = Math.max(max, left + right + node.val); // See if subtree is bigger
        return Math.max(left, right) + node.val; // Return the max branch path to take
    }
}

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
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        // Get the total sum
        // Traverse again, in order and buid up the sum
        // Set the sum to the curr, then subtract the current value
        sum = getSum(root);
        helper(root);
        return root;
    }

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + getSum(root.left) + getSum(root.right);
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            helper(root.left);
        }
        int temp = root.val;
        root.val = sum;
        sum -= temp;
        if (root.right != null) {
            helper(root.right);
        }
    }
}

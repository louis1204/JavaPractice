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
    boolean equal = false;
    public boolean checkEqualTree(TreeNode root) {
        getSum(root);
        if (sum % 2 != 0) {
            return false;
        }
        helper(root, true);
        return equal;
    }
    
    int helper(TreeNode node, boolean isRoot) {
        if (equal) return 0;
        if (node == null) {
            return 0;
        }
        int leftSum = helper(node.left, false);
        int rightSum = helper(node.right, false);
        int curr = node.val + leftSum + rightSum;
        if (!isRoot && curr * 2 == sum) {
            equal = true;
        }
        return curr;
    }
    void getSum(TreeNode node) {
        if (node == null) return;
        sum += node.val;
        getSum(node.left);
        getSum(node.right);
    }
}

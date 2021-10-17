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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        helper(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }
    
    private void helper(TreeNode curr, int targetSum, int currSum) {
        if (curr == null) {
            return;
        }
        currSum += curr.val;
        if (currSum == targetSum) {
            res++;
        }
        helper(curr.left, targetSum, currSum);
        helper(curr.right, targetSum, currSum);
    }
}

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
    double max = 0.0;
    
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return max;
    }
    
    private Pair<Integer, Integer> helper(TreeNode node) {
        if (node == null) {
            return null;
        }
        // if (node.left == null && node.right == null) {
        //     max = Math.max(max, node.val);
        //     return new Pair<>(node.val, 1);
        // }
        Pair<Integer, Integer> left = helper(node.left);
        Pair<Integer, Integer> right = helper(node.right);
        int currSum = node.val;
        int currCount = 1;
        if (left != null) {
            currSum += left.getKey();
            currCount += left.getValue();
        }
        if (right != null) {
            currSum += right.getKey();
            currCount += right.getValue();
        }
        max = Math.max(max, currSum / (double) currCount);
        return new Pair<>(currSum, currCount);
    }
}

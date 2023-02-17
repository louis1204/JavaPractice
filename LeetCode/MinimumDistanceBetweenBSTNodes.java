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
    int min = Integer.MAX_VALUE;
    List<Integer> nums = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        helper(root);
        return min;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (!nums.isEmpty()) {
            min = Math.min(min, root.val - nums.get(nums.size() - 1));
        }
        nums.add(root.val);
        helper(root.right);
    }
}

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
    Set<Integer> seen = new HashSet<>();

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int lo, int hi) {
        int pos = (lo + hi) / 2;
        if (seen.contains(pos) || pos >= nums.length || pos < 0) {
            return null;
        }
        TreeNode curr = new TreeNode(nums[pos]);
        seen.add(pos);
        // left
        curr.left = helper(nums, lo, pos - 1);
        curr.right = helper(nums, pos + 1, hi);
        return curr;
    }
}

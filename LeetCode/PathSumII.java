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
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(0, targetSum, root, new ArrayList<>());
        return res;
    }
    
    private void helper(int sum, int target, TreeNode root, List<Integer> curr) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                List<Integer> copy = new ArrayList<>() {{
                    addAll(curr);
                }};
                copy.add(root.val);
                res.add(copy);
            }
            return;
        }
        curr.add(root.val);
        helper(sum + root.val, target, root.left, curr);
        helper(sum + root.val, target, root.right, curr);
        curr.remove(curr.size() - 1);
    }
}

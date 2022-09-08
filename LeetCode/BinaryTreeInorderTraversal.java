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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> dfs = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs.push(root);
        while (!dfs.empty()) {
            TreeNode parent = dfs.pop();
            if (parent.right != null) {
                TreeNode right = parent.right;
                parent.right = null;
                dfs.push(right);
            }
            if (parent.left == null) {
                result.add(parent.val);
            } else {
                TreeNode left = parent.left;
                parent.left = null;
                dfs.push(parent);
                dfs.push(left);
            }
        }
        return result;
    }
}

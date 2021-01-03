/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfsFind(cloned, target.val);
    }
    
    private TreeNode dfsFind(TreeNode node, int target) {
        if (node.val == target) {
            return node;
        }
        TreeNode res = null;
        if (node.left != null) {
            res = dfsFind(node.left, target);
        }
        if (res == null && node.right != null) {
            res = dfsFind(node.right, target);
        }
        return res;
    }
}

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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while (root.left != null || root.right != null) {
            List<Integer> leaves = new ArrayList<>();
            pruneLeaves(root, leaves);
            res.add(leaves);
        }
        res.add(new ArrayList<>() {{
            add(root.val);
        }});
        return res;
    }
    
    public boolean pruneLeaves(TreeNode root, List<Integer> leaves) {
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            root = null;
            return true;
        }
        if (root.left != null) {
            if (pruneLeaves(root.left, leaves)) {
                root.left = null;
            }
        }
        if (root.right != null) {
            if (pruneLeaves(root.right, leaves)) {
                root.right = null;
            }
        }
        return false;
    }
}

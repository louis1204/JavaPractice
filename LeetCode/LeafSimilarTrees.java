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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        getLeaves(root1, leaves1);
        List<Integer> leaves2 = new ArrayList<>();
        getLeaves(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void getLeaves(TreeNode root, List<Integer> res) {
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        if (root.left != null) {
            getLeaves(root.left, res);
        }
        if (root.right != null) {
            getLeaves(root.right, res);
        }
    }
}

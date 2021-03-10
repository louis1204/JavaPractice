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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v, root, null);
            return newRoot;
        }
        int level = 1;
        List<TreeNode> prevLevel = new ArrayList<>();
        prevLevel.add(root);
        while (level + 1 != d) {
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node : prevLevel) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            prevLevel = nextLevel;
            level++;
        }
        // Now we swap
        for (TreeNode node : prevLevel) {
            TreeNode tempLeft = node.left;
            TreeNode tempRight = node.right;
            TreeNode newLeft = new TreeNode(v, tempLeft, null);
            TreeNode newRight = new TreeNode(v, null, tempRight);
            node.left = newLeft;
            node.right = newRight;
        }
        return root;
    }
}

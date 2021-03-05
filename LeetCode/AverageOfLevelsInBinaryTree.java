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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            double sum = 0;
            for (TreeNode node : q) {
                sum += node.val;
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            res.add(sum / (double) q.size());
            q = next;
        }
        return res;
    }
}

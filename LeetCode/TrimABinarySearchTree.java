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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        List<TreeNode> list = new ArrayList<>();
        getTrim(list, root, low, high);
        if (list.isEmpty()) {
            return null;
        }
        TreeNode res = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).left = null;
            list.get(i).right = null;
        }
        for (int i = 1; i < list.size(); i++) {
            insert(res, list.get(i));
        }
        return res;
    }
    
    private void insert(TreeNode root, TreeNode insert) {
        if (insert.val < root.val) {
            if (root.left == null) {
                root.left = insert;
                return;
            }
            insert(root.left, insert);
            return;
        }
        if (insert.val > root.val) {
            if (root.right == null) {
                root.right = insert;
                return;
            }
            insert(root.right, insert);
            return;
        }
    }
    
    private void getTrim(List<TreeNode> res, TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }
        if (node.val >= low && node.val <= high) {
            res.add(node);
        }
        getTrim(res, node.left, low, high);
        getTrim(res, node.right, low, high);
    }
}

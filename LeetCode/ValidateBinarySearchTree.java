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
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove(0);
            if (node == null) {
                continue;
            }
            if (node.left == null && node.right == null) {
                inorder.add(node.val);
                continue;
            }
            TreeNode right = node.right;
            TreeNode left = node.left;
            queue.add(0, right);
            queue.add(0, node);
            queue.add(0, left);
            node.left = null;
            node.right = null;
        }
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i - 1) >= inorder.get(i)) {
                return false;
            }
        }
        return true;
    }
}

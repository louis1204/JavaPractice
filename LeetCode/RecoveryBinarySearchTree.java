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
    List<TreeNode> inorder = new ArrayList<>();
    
    public void recoverTree(TreeNode root) {
        helper(root);
        TreeNode first = null;
        TreeNode second = null;
        for (int i = 0; i < inorder.size(); i++) {
            TreeNode left = inorder.get(Math.max(0, i - 1));
            TreeNode right = inorder.get(Math.min(inorder.size() - 1, i + 1));
            TreeNode curr = inorder.get(i);
            
            if (curr.val < left.val || curr.val > right.val) {
                if (first == null) {
                    first = curr;
                } else {
                    second = curr;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void helper(TreeNode root) {
        if (root == null) return;
        
        helper(root.left);
        inorder.add(root);
        helper(root.right);
    }
}

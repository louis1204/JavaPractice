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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        getPreorder(root, stack);
        TreeNode child = stack.pop();
        child.left = null;
        child.right = null;
        while (!stack.isEmpty()) {
            stack.peek().left = null;
            stack.peek().right = child;
            child = stack.pop();
        }
    }
    
    private void getPreorder(TreeNode root, Stack<TreeNode> stack) {
        if (root == null) {
            return;
        }
        stack.push(root);
        getPreorder(root.left, stack);
        getPreorder(root.right, stack);
    }
}

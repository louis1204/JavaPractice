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
    PriorityQueue<Integer> heap =  new PriorityQueue<>((a, b) -> b - a);
    int res = 0;
    
    public int goodNodes(TreeNode root) {
        helper(root);
        return res;
    }
    
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (heap.isEmpty() || heap.peek() <= root.val) {
            res++;
        }
        heap.offer(root.val);
        
        helper(root.left);
        helper(root.right);
        
        heap.remove(root.val);
    }
}

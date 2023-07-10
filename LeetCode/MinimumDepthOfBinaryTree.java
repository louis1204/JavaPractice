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
    public int minDepth(TreeNode root) {
        int level = 1;
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        
        while (!bfs.isEmpty()) {
            Deque<TreeNode> temp = new LinkedList<>();
            while (!bfs.isEmpty()) {
                TreeNode next = bfs.poll();
                if (next.left == null && next.right == null) {
                    return level;
                }
                if (next.left != null) {
                    temp.offer(next.left);
                }
                if (next.right != null) {
                    temp.offer(next.right);
                }
            }
            level++;
            bfs = temp;
        }
        return 0;
    }
}

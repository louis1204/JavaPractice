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
    public boolean isCousins(TreeNode root, int x, int y) {
        // Same depth, different parents
        int xParent = 0;
        int yParent = 0;
        int xDepth = 0;
        int yDepth = 0;
        
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int level = 1;
        while (!queue.isEmpty()) {
            Deque<TreeNode> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                if (curr.val == x) {
                    xDepth = level;
                }
                if (curr.val == y) {
                    yDepth = level;
                }
                if ((curr.left != null && curr.left.val == x) || (curr.right != null && curr.right.val == x)) {
                    xParent = curr.val;
                }
                if ((curr.left != null && curr.left.val == y) || (curr.right != null && curr.right.val == y)) {
                    yParent = curr.val;
                }
                if (curr.left != null) {
                    next.offer(curr.left);
                }
                if (curr.right != null) {
                    next.offer(curr.right);
                }
            }
            queue = next;
            level++;
        }
        System.out.println("xparent->" + xParent + " yparent->" + yParent + " xDepth->" + xDepth + " yDepth->" + yDepth);
        if (xParent == 0 || yParent == 0 || yDepth == 0 || xDepth == 0 || yDepth != xDepth || xParent == yParent) {
            return false;
        }
        return true;
    }
}

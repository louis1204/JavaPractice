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
    public int maxLevelSum(TreeNode root) {
        int mod = (int) 1e7;
        // Just do bfs
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        int maxSum = Integer.MIN_VALUE;
        int maxLevelSum = 1;
        while (!queue.isEmpty()) {
            Deque<TreeNode> nextQueue = new LinkedList<>();
            int sum = 0;
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                // sum %= mod;
                if (curr.left != null) {
                    nextQueue.offer(curr.left);
                }
                if (curr.right != null) {
                    nextQueue.offer(curr.right);
                }
            }
            queue = nextQueue;
            if (sum > maxSum) {
                maxSum = sum;
                maxLevelSum = level;
            }
            level++;
        }
        return maxLevelSum;
    }
}

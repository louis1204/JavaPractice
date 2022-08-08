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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // Map of integer to represent column index
        // return min index
        if (root == null) {
            return new ArrayList<>();
        }
        HashMap<Integer, List<Integer>> col = new HashMap<>();
        // Do BFS instead with HashMap of Node to index then add to col
        HashMap<TreeNode, Integer> index = new HashMap<>();
        index.put(root, 0);
        int min = 0;
        List<TreeNode> bfs = new ArrayList<>();
        bfs.add(root);
        while (!bfs.isEmpty()) {
            TreeNode node = bfs.remove(0);
            min = Math.min(min, index.get(node));
            List<Integer> nodes = col.getOrDefault(index.get(node), new ArrayList<>());
            nodes.add(node.val);
            col.put(index.get(node), nodes);
            if (node.left != null) {
                index.put(node.left, index.get(node) - 1);
                bfs.add(node.left);
            }
            if (node.right != null) {
                index.put(node.right, index.get(node) + 1);
                bfs.add(node.right);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (col.containsKey(min)) {
            res.add(col.get(min++));
        }
        return res;
    }
}

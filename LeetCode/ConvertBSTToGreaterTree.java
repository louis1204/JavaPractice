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
    public TreeNode convertBST(TreeNode root) {
        // Inorder traverse into an array
        // Go from right to left and accumulate sum and add
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        getInorder(root, list);
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int temp = list.get(i).val;
            list.get(i).val += sum;
            sum += temp;
        }
        return root;
    }
    
    private void getInorder(TreeNode node, List<TreeNode> list) {
        if (node.left != null) {
            getInorder(node.left, list);
        }
        list.add(node);
        if (node.right != null) {
            getInorder(node.right, list);
        }
    }
}

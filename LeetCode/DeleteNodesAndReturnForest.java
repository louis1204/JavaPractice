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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // Go through all the nodes, if it is deleted, add its children to the result if they're not deleted
        // recurse on children
        // Lastly add the top root, unless that is deleted
        HashSet<Integer> delete = new HashSet<>();
        for (int n : to_delete) {
            delete.add(n);
        }
        List<TreeNode> result = new ArrayList<>();
        helper(result, delete, root);
        if (!delete.contains(root.val)) {
            result.add(root);
        }
        return result;
    }

    private boolean helper(List<TreeNode> result, HashSet<Integer> delete, TreeNode curr) {
        if (curr == null) {
            return false;
        }
        if (delete.contains(curr.val)) {
            if (curr.left != null && !delete.contains(curr.left.val)) {
                result.add(curr.left);
            }
            if (curr.right != null && !delete.contains(curr.right.val)) {
                result.add(curr.right);
            }
        }
        if (helper(result, delete, curr.left)) {
            curr.left = null;
        }
        if (helper(result, delete, curr.right)) {
            curr.right = null;
        }
        return delete.contains(curr.val);
    }
}

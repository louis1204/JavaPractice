/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<TreeNode> all = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            all.add(curr);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        all.sort((a, b) -> a.val - b.val);
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).val == p.val) {
                if (i != all.size() - 1) {
                    return all.get(i + 1);
                }
            }
        }
        return null;
    }
}

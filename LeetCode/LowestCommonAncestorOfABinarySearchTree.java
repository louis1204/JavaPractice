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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<Pair<TreeNode, Integer>> pAncestors = new HashSet<>();
        Set<Pair<TreeNode, Integer>> qAncestors = new HashSet<>();
        getAllAncestors(p, root, pAncestors, 0);
        getAllAncestors(q, root, qAncestors, 0);
        TreeNode lca = null;
        int lowest = Integer.MIN_VALUE;
        for (var ancestor : pAncestors) {
            if (qAncestors.contains(ancestor)) {
                if (ancestor.getValue() > lowest) {
                    lca = ancestor.getKey();
                    lowest = ancestor.getValue();
                }
            }
        }
        return lca;
    }
    
    private boolean getAllAncestors(TreeNode end, TreeNode root, Set<Pair<TreeNode, Integer>> ancestors, int level) {
        if (root == end) {
            ancestors.add(new Pair<>(root, level));
            return true;
        }
        if (root == null) {
            return false;
        }
        if (getAllAncestors(end, root.left, ancestors, level + 1) ||
                getAllAncestors(end, root.right, ancestors, level + 1)) {
            ancestors.add(new Pair<>(root, level));
            return true;
        }
        return false;
    }
}

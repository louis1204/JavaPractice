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
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Go through the descriptions
        // Create a hashmap of parent to children, left and right
        // Afterwards, find the parent and create the binary tree
        // We can also create a hashmap of "has parent" for each node encountered
        HashMap<Integer, Boolean> hasParent = new HashMap<>();
        HashMap<Integer, int[]> children = new HashMap<>(); // use -1 to denote that it's an empty child
        for (int[] desc : descriptions) {
            hasParent.put(desc[1], true);
            int[] existing = children.getOrDefault(desc[0], new int[] {-1, -1});
            existing[desc[2] == 1 ? 0 : 1] = desc[1];
            children.put(desc[0], existing);
            if (!hasParent.containsKey(desc[0])) {
                hasParent.put(desc[0], false);
            }
        }
        // Get the root
        int parent = 0;
        for (var entries : hasParent.entrySet()) {
            if (!entries.getValue()) {
                parent = entries.getKey();
            }
        }
        // Create the tree
        return createTree(parent, children);
    }

    private TreeNode createTree(int parent, HashMap<Integer, int[]> children) {
        TreeNode curr = new TreeNode(parent);
        if (children.containsKey(parent)) {
            int[] child = children.get(parent);
            if (child[0] != -1) {
                curr.left = createTree(child[0], children);
            }
            if (child[1] != -1) {
                curr.right = createTree(child[1], children);
            }
        }
        return curr;
    }
}

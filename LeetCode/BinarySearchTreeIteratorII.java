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
class BSTIterator {

    List<Integer> inorder = new ArrayList<>();
    int ind = -1;
    
    public BSTIterator(TreeNode root) {
        helper(root);
    }
    
    private void helper(TreeNode root) {
        if (root == null) return;
        
        if (root.left != null) {
            helper(root.left);
        }
        inorder.add(root.val);
        if (root.right != null) {
            helper(root.right);
        }
    }
    
    public boolean hasNext() {
        return ind < inorder.size() - 1 && !inorder.isEmpty();
    }
    
    public int next() {
        return inorder.get(++ind);
    }
    
    public boolean hasPrev() {
        return ind > 0 && !inorder.isEmpty();
    }
    
    public int prev() {
        return inorder.get(--ind);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */

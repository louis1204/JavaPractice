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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> inorder1 = new ArrayList<>();
        List<Integer> inorder2 = new ArrayList<>();
    
        // Inorder both and create 2 lists
        inorder(root1, inorder1);
        inorder(root2, inorder2);
        // Then merge both
        int ptr1 = 0;
        int ptr2 = 0;
        
        List<Integer> res = new ArrayList<>();
        while (ptr1 < inorder1.size() && ptr2 < inorder2.size()) {
            if (inorder1.get(ptr1) <= inorder2.get(ptr2)) {
                res.add(inorder1.get(ptr1));
                ptr1++;
            } else {
                res.add(inorder2.get(ptr2));
                ptr2++;
            }
        }
        while (ptr1 < inorder1.size()) {
            res.add(inorder1.get(ptr1));
            ptr1++;
        }
        
        while (ptr2 < inorder2.size()) {
            res.add(inorder2.get(ptr2));
            ptr2++;
        }
        return res;
    }
    
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}

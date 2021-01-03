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
    HashMap<Integer, Integer> numToCount = new HashMap<>();
    int res = 0;
    public int pseudoPalindromicPaths(TreeNode root) {
        if (root.left == null && root.right == null) {
            numToCount.put(root.val, numToCount.getOrDefault(root.val, 0) + 1);
            checkAtMostOneOdd();
            numToCount.put(root.val, numToCount.get(root.val) - 1);
            // System.out.println(" res: " + res);
            return res;
        }
        // System.out.print("" + root.val + "->");
        numToCount.put(root.val, numToCount.getOrDefault(root.val, 0) + 1);
        if (root.left != null) {
            pseudoPalindromicPaths(root.left);
        }
        if (root.right != null) {
            pseudoPalindromicPaths(root.right);
        }
        numToCount.put(root.val, numToCount.get(root.val) - 1);
        return res;
    }
    
    private void checkAtMostOneOdd() {
        int oddCount = 0;
        for (var entry : numToCount.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                return;
            }
        }
        res++;
    }
}

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
    HashMap<Integer, List<Point>> res = new HashMap<>();
    int lowest = 0;
    int highest = 0;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // DFS and keep track of its index
        helper(root, 0, 0, 0);
        // System.out.println(res.toString());
        List<List<Integer>> actualRes = new ArrayList<>();
        for (int i = lowest; i <= highest; i++) {
            List<Point> temp = res.get(i);
            temp.sort((a, b) -> a.compareTo(b));
            actualRes.add(temp.stream().map(p -> p.val).collect(Collectors.toList()));
        }
        return actualRes;
    }
    
    private void helper(TreeNode root, int X, int Y, int time) {
        if (root == null) {
            return;
        }
        List<Point> existing = res.getOrDefault(X, new ArrayList<>());
        existing.add(new Point(X, Y, root.val, time));
        res.put(X, existing);
        lowest = Math.min(lowest, X);
        highest = Math.max(highest, X);
        
        helper(root.left, X - 1, Y - 1, time + 1);
        helper(root.right, X + 1, Y - 1, time + 1);
    }
    
    class Point implements Comparable {
        int X;
        int Y;
        int val;
        int time;
        public Point(int X, int Y, int val, int time) {
            this.X = X;
            this.Y = Y;
            this.val = val;
            this.time = time;
        }
        
        @Override
        public int compareTo(Object o) {
            Point other = (Point) o;
            if (this.Y == other.Y && this.X == other.X) {
                if (this.time == other.time) {
                    return this.val - other.val;
                } else {
                    return this.time - other.time;
                }
            } else {
                return other.Y - this.Y;
            }
        }
        
        public String toString() {
            return "X: " + X + " Y: " + Y + " val: " + val + " time: " + time + "|";
        }
    }
}

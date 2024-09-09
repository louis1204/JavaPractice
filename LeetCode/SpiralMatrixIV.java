/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // Decrement m and n each time we hit the end
        int[][] res = new int[m][n];
        // fill with -1
        for (int[] row : res) {
            Arrays.fill(row, -1);
        }
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirInd = 0;
        int walkAmt = n--;
        m--;
        int[] pos = new int[]{0, 0};
        while (head != null) {
            res[pos[0]][pos[1]] = head.val;
            head = head.next;
            walkAmt--;
            if (walkAmt <= 0) {
                // check if going horizontal or vertical
                if (dirInd == 0 || dirInd == 2) {
                    walkAmt = m--;
                } else {
                    walkAmt = n--;
                }
                dirInd++;
                dirInd %= 4;
            }
            pos[0] += dirs[dirInd][0];
            pos[1] += dirs[dirInd][1];
        }
        return res;
    }
}

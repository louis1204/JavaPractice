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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode headToReturn = head;
        while (head != null && head.next != null) {
            ListNode curr = head;
            ListNode next = head.next;
            int gcd = findGcd(curr.val, next.val);
            ListNode gcdNode = new ListNode(gcd);
            curr.next = gcdNode;
            gcdNode.next = next;
            head = next;
        }
        return headToReturn;
    }

    private int findGcd(int val1, int val2) {
        int lower = Math.min(val1, val2);
        while (lower > 0) {
            if (val1 % lower == 0 && val2 % lower == 0) {
                return lower;
            }
            lower--;
        }
        // Shouldn't reach
        return -1;
    }
}

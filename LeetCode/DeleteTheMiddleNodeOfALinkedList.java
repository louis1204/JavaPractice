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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // Delete the slow
        System.out.println(slow.val);
        ListNode slowTail = null;
        while (slow.next != null) {
            slow.val = slow.next.val;
            slowTail = slow;
            slow = slow.next;
        }
        if (slowTail != null) {
            slowTail.next = null;
        } else {
            head.next = null;
        }
        return head;
    }
}

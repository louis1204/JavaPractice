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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // init head
        ListNode head = null;
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }
        } else {
            return l1 != null ? l1 : l2;
        }
        // add from lists
        ListNode headPointer = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                headPointer.next = l1;
                headPointer = headPointer.next;
                l1 = l1.next;
            } else {
                headPointer.next = l2;
                headPointer = headPointer.next;
                l2 = l2.next;
            }
        }
        // finally if either is still not empty add to head pointer
        if (l1 != null) headPointer.next = l1;
        if (l2 != null) headPointer.next = l2;
        return head;
    }
}

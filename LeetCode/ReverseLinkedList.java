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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head.next;
        head.next = null;
        return helper(head, temp);
    }
    
    private ListNode helper(ListNode prev, ListNode curr) {
        if (curr == null) {
            return prev;
        }
        ListNode temp = curr.next;
        curr.next = prev;
        return helper(curr, temp);
    }
}

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
    public ListNode mergeNodes(ListNode head) {
        // Might be able to do this in one resursive function
        // Check if curr is 0, if so, return merge nodes of next
        // If  curr is not 0, check if next is 0, if it is, set the next to the merge nodes
        // of next. If next is not 0, add the curr value to the next value and merge nodes on that
        // if curr is null, return null
        if (head == null) {
            return null;
        }
        if (head.val == 0) {
            return mergeNodes(head.next);
        } else if (head.next.val == 0) {
            head.next = mergeNodes(head.next);
            return head;
        } else { // head.val != 0 && head.next.val != 0
            head.next.val += head.val;
            return mergeNodes(head.next);
        }
    }
}

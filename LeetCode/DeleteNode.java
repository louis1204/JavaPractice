/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // Essentially shrink the list by one
        ListNode prev = null;
        while (node.next != null) {
            prev = node;
            ListNode next = node.next;
            node.val = next.val;
            node = next;
        }
        prev.next = null;
    }
}

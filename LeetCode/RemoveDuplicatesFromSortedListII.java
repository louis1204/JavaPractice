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
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> count = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            count.put(temp.val, count.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }
        List<ListNode> res = new ArrayList<>();
        // Move to actual head
        while (head != null && count.get(head.val) != 1) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode next = head.next;
        while (next != null) {
            while (next != null && count.get(next.val) != 1) {
                next = next.next;
            }
            prev.next = next;
            prev = next;
            if (next != null) {
                next = next.next;
            }
        }
        return head;
    }
}

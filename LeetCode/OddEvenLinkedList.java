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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = null;
        ListNode evenHead = null;
        int counter = 0;
        ListNode temp = head;
        ListNode actualOddHead = null;
        while (temp != null) {
            if (counter % 2 == 0) {
                if (evenHead != null) {
                    evenHead.next = temp;
                }
                evenHead = temp;
            } else {
                if (oddHead != null) {
                    oddHead.next = temp;
                } else {
                    actualOddHead = temp;
                }
                oddHead = temp;
            }
            counter++;
            temp = temp.next;
        }
        if (oddHead != null) {
            oddHead.next = null;
        }
        if (evenHead != null) {
            evenHead.next = actualOddHead;
        }
        return head;
    }
}

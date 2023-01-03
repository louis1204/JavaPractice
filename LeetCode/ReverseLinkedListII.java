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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        return helper(head, left, right, 1);
    }

    public ListNode helper(ListNode head, int left, int right, int currPos) {
        if (head == null) {
            return null;
        }
        // System.out.println(head.val);
        if (currPos == left) {
            Stack<ListNode> nodes = new Stack<>();
            ListNode curr = head;
            while (currPos != right) {
                nodes.push(curr);
                // System.out.println(curr.val);
                curr = curr.next;
                currPos++;
            }
            // System.out.println(curr.val);
            nodes.push(curr);
            head.next = curr.next;
            ListNode prev = null;
            while (!nodes.isEmpty()) {
                if (prev == null) {
                    prev = nodes.pop();
                    continue;
                }
                prev.next = nodes.peek();
                prev = nodes.pop();
            }
            // System.out.println(head.val);
            // System.out.println(curr.val);
            return curr;
        }
        head.next = helper(head.next, left, right, currPos + 1);
        return head;
    }
}

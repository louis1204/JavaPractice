/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // We can use a set but that will take o(n) space
        
        // We can detect a loop with 2 pointers with one slow and one fast
        // However this is not gauranteed to find the first element in the loop
        
        // We can make the slow super slow, check if it is the first in the loop each time
        
        ListNode superSlow = head;
        while (superSlow != null) {
            // System.out.println("outerloop");
            if (isFirst(superSlow)) {
                return superSlow;
            }
            superSlow = superSlow.next;
        }
        return null;
    }
    
    private boolean isFirst(ListNode node) {
        ListNode slow = node.next;
        ListNode fast = node.next;
        if (fast == null || fast.next == null) {
            return false;
        }
        fast = fast.next;
        while (fast != null) { // Could have an inf loop here
            // System.out.print("loophere");
            if (fast == node || slow == node || fast.next == node) {
                return true;
            }
            if (fast == slow || fast.next == slow) { // in the loop and node is not part of it
                return false;
            }
            fast = fast.next;
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return false;
    }
}

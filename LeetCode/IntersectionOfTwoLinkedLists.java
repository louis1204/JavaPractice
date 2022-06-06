/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> seen = new HashSet<>();
        while (headA != null) {
            seen.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (seen.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}

// The O(1) memory restriction. Runtime is a lot faster as well 1ms vs 7ms
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // O(1) memory usage method
        // Get the lengths of A and B
        // EG 5, 6, then we need to increment the longer one by the difference
        // then increment both until they're both pointing at the same node
        int aSize = 0;
        ListNode tempA = headA;
        while (tempA != null) {
            aSize++;
            tempA = tempA.next;
        }
        
        int bSize = 0;
        ListNode tempB = headB;
        while (tempB != null) {
            bSize++;
            tempB = tempB.next;
        }
        
        if (aSize > bSize) {
            for (int i = 0; i < aSize - bSize; i++) {
                headA = headA.next;
            }
        } else if (bSize > aSize) {
            for (int i = 0; i < bSize - aSize; i++) {
                headB = headB.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}

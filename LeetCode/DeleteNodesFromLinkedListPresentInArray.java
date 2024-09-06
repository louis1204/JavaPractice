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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // Go through the list, add to a queue if it's not in the set, then return the result
        Deque<ListNode> queue = new LinkedList<>();
        while (head != null) {
            if (!set.contains(head.val)) {
                queue.offer(head);
            }
            head = head.next;
        }
        ListNode nodeToReturn = queue.peek();
        ListNode curr;
        while (!queue.isEmpty() && (curr = queue.poll()) != null) {
            if (!queue.isEmpty()) {
                curr.next = queue.peek();
            } else {
                curr.next = null;
            }
        }
        return nodeToReturn;
    }
}

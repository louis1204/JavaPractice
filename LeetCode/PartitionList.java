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
    public ListNode partition(ListNode head, int x) {
        // Two pointers after we find the first diff
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (list.isEmpty()) {
            return null;
        }
        // Find first violation
        int first = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).val >= x) {
                first = i;
                break;
            }
        }
        if (first == -1) {
            return list.get(0);
        }
        // Every number that's under after the first violation gets added to this list
        List<ListNode> unders = new ArrayList<>();
        for (int i = first + 1; i < list.size();) {
            if (list.get(i).val < x) {
                unders.add(list.get(i));
                list.remove(i);
                continue;
            }
            i++;
        }
        List<ListNode> finalList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i == first) {
                finalList.addAll(unders);
            }
            finalList.add(list.get(i));
        }
        for (int i = 0; i < finalList.size(); i++) {
            if (i == finalList.size() - 1) {
                finalList.get(i).next = null;
            } else {
                finalList.get(i).next = finalList.get(i + 1);
            }
        }
        return finalList.get(0);
    }
}

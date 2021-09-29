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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        int portion = list.size() / k;
        int leftOvers = list.size() - (portion * k);
        if (portion == 0) {
            portion = 1;
            leftOvers = 0;
        }
        int listInd = 0;
        // System.out.println(list.size());
        // System.out.println(k);
        // System.out.println(portion);
        
        for (int i = 0; i < res.length; i++) {
            if (listInd >= list.size()) {
                break;
            }
            res[i] = list.get(listInd);
            listInd += portion;
            if (leftOvers > 0) {
                 listInd += 1;
                leftOvers--;
            }
            if (listInd - 1 < list.size()) {
                list.get(listInd - 1).next = null;
            }
        }
        return res;
    }
}

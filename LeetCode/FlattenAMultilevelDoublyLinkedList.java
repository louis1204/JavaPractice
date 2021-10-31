/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    List<Node> list = new ArrayList<>();
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        helper(head);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).child = null;
            if (i < list.size() - 1) {
                list.get(i).next = list.get(i + 1);
            } else {
                list.get(i).next = null;
            }
            list.get(i).prev = i > 0 ? list.get(i - 1) : null;
        }
        return list.get(0);
    }
    
    private void helper(Node curr) {
        if (curr == null) {
            return;
        }
        list.add(curr);
        helper(curr.child);
        helper(curr.next);
    }
}

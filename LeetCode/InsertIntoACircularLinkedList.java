/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (head == head.next) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node curr = head.next;
        Node prev = head;
        while (curr != head) {
            if (insertVal >= prev.val && insertVal <= curr.val) {
                prev.next = node;
                node.next = curr;
                return head;
            }
            if (prev.val > curr.val && (insertVal <= curr.val || insertVal >= prev.val)) {
                prev.next = node;
                node.next = curr;
                return head;
            }
            curr = curr.next;
            prev = prev.next;
        }
        // Doesn't fit anywhere
        prev.next = node;
        node.next = curr;
        return head;
    }
}

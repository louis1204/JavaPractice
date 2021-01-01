class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // Create a doubly linked list with a hashmap and remove in order
        // If we can't return false
        // Check if all nodes all nulled out
        HashMap<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            nodes.put(arr[i], node);
        }
        for (int i = 1; i < arr.length - 1; i++) {
            Node node = nodes.get(arr[i]);
            node.prev = nodes.get(arr[i - 1]);
            node.next = nodes.get(arr[i + 1]);
        }
        if (nodes.size() > 1) {
            Node first = nodes.get(arr[0]);
            first.next = nodes.get(arr[1]);
            Node last = nodes.get(arr[arr.length - 1]);
            last.prev = nodes.get(arr[arr.length - 2]);
        }
        
        for (int[] piece : pieces) {
            if (piece.length == 0) {
                continue;
            }
            Node curr = nodes.get(piece[0]);
            for (int val : piece) {
                if (curr == null || curr.val != val) {
                    return false;
                }
                Node prev = curr.prev;
                Node next = curr.next;
                if (prev != null) {
                    prev.next = null;
                }
                if (next != null) {
                    next.prev = null;
                }
                nodes.put(val, null);
                curr = next;
                // System.out.println(nodes.toString());
            }
        }
        // System.out.println(nodes.toString());
        for (var entry : nodes.entrySet()) {
            if (entry.getValue() != null) {
                return false;
            }
        }
        return true;
    }
    
    class Node {
        Node prev;
        Node next;
        int val;
        public Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}

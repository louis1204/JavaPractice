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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // Just go through the list and get the critical points
        // For the maximum, it will be the last - first
        // For the min, we have to go through the pairs and find the min dist
        List<Integer> points = new ArrayList<>();
        int prev = -1;
        int counter = 1;
        while (head != null) {
            if (prev == -1 || head.next == null) { // The ends
                prev = head.val;
                head = head.next;
                counter++;
                continue;
            }
            // minima
            if (prev > head.val && head.val < head.next.val) {
                points.add(counter);
                prev = head.val;
                head = head.next;
                counter++;
                continue;
            }
            // maxima
            if (prev < head.val && head.val > head.next.val) {
                points.add(counter);
                prev = head.val;
                head = head.next;
                counter++;
                continue;
            }
            prev = head.val;
            head = head.next;
            counter++;
        }
        if (points.size() < 2) {
            return new int[] {-1, -1};
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < points.size(); i++) {
            min = Math.min(min, points.get(i) - points.get(i - 1));
        }
        // System.out.println(points);
        return new int[]{min, points.get(points.size() - 1) - points.get(0)};
    }
}

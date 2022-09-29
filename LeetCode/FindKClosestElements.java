class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Can we just use a heap with a custom comparator?
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
            int aDist = Math.abs(a - x);
            int bDist = Math.abs(b - x);
            if (aDist == bDist) {
                return a - b;
            }
            return aDist - bDist;
        });
        for (int a : arr) {
            heap.offer(a);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(heap.poll());
        }
        res.sort((a, b) -> a - b);
        return res;
    }
}

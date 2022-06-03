class Solution {
    public int minKnightMoves(int x, int y) {
        // BFS, with seen squares?
        boolean[][] seen = new boolean[605][605]; // 302 should be our max in both sides, so multiply that by 2 and we get 604. We use 605 due to the indexing to be max of 604
        int[][] dirs = new int[][]{{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
                                   {1, -2}, {2, -1}, {2, 1}, {1, 2}};
        Deque<Pair<Integer, Integer>> queue = new LinkedList<>();
        Pair<Integer, Integer> origin = new Pair<>(0, 0);
        queue.offer(origin);
        seen[302][302] = true;
        
        Pair<Integer, Integer> target = new Pair<>(x, y);
        
        int move = 0;
        
        while (!queue.isEmpty()) {
            Deque<Pair<Integer, Integer>> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                Pair<Integer, Integer> curr = queue.poll();
                if (curr.equals(target)) {
                    return move;
                }
                for (int[] dir : dirs) {
                    Pair<Integer, Integer> n = new Pair<>(curr.getKey() + dir[0], curr.getValue() + dir[1]);
                    if (!seen[n.getKey() + 302][n.getValue() + 302] && Math.abs(n.getKey()) <= Math.abs(x) + 2 && Math.abs(n.getValue()) <= Math.abs(y) + 2) {
                        next.offer(n);
                    }
                    seen[n.getKey() + 302][n.getValue() + 302] = true;
                }
            }
            queue = next;
            // System.out.println(queue);
            move++;
        }
        return move; // shouldn't reach
    }
}

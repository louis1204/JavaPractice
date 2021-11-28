class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // BFS
        HashMap<Integer, List<Integer>> bfs = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> existing = bfs.getOrDefault(i, new ArrayList<>());
            for (int neigh : graph[i]) {
                existing.add(neigh);
            }
            bfs.put(i, existing);
        }

        List<List<Integer>> res = new ArrayList<>();
        int end = bfs.size() - 1;
        
        Deque<List<Integer>> queue = new LinkedList<>();
        List<Integer> init = new ArrayList<>() {{
            add(0);
        }};
        queue.offer(init);
        while (!queue.isEmpty()) {
            List<Integer> next = queue.poll();
            for (Integer neigh : bfs.get(next.get(next.size() - 1))) {
                List<Integer> nextCopy = copy(next);
                nextCopy.add(neigh);
                if (neigh == end) {
                    res.add(nextCopy);
                } else {
                    queue.offer(nextCopy);
                }
            }
        }
        return res;
    }
    
    private List<Integer> copy(List<Integer> list) {
        List<Integer> copy = new ArrayList<>() {{
            addAll(list);
        }};
        return copy;
    }
}

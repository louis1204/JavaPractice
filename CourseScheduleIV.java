class Solution {
    HashMap<Pair<Integer, Integer>, Boolean> cache = new HashMap<>();
    
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            Set<Integer> existing = graph.getOrDefault(pre[0], new HashSet<>());
            existing.add(pre[1]);
            graph.put(pre[0], existing);
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(isPrereq(q[0], q[1], graph, new HashSet<>()));
        }
        return res;
    }
    
    private boolean isPrereq(int start, int target, HashMap<Integer, Set<Integer>> graph, HashSet<Integer> seen) {
        Pair<Integer, Integer> pair = new Pair<>(start, target);
        if (cache.containsKey(pair)) {
            return cache.get(pair);
        }
        Set<Integer> next = graph.getOrDefault(start, new HashSet<>());
        if (next.contains(target)) {
            cache.put(pair, true);
            return true;
        }
        seen.add(start);
        for (Integer course : next) {
            if (isPrereq(course, target, graph, seen)) {
                cache.put(pair, true);
                return true;
            }
            // cache.put(new Pair<>(course, target), false);
        }
        seen.remove(start);
        cache.put(pair, false);
        return false;
    }
}

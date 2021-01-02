class Solution {
    int[] cache = new int[0];
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        cache = new int[numCourses]; // 0 = not sure, 1 = no loops
        // Just need to see if the's no cycles in the prereqs
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            Set<Integer> existing = graph.getOrDefault(pre[1], new HashSet<>());
            if (existing.contains(pre[0])) {
                return false;
            }
            existing = graph.getOrDefault(pre[0], new HashSet<>());
            existing.add(pre[1]);
            graph.put(pre[0], existing);
        }
        // For each prereq, dfs and see if there's any loops
        for (int[] pre : prerequisites) {
            if (hasLoop(pre[0], graph, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }
    
    private boolean hasLoop(int pre, HashMap<Integer, Set<Integer>> graph, Set<Integer> seen) {
        if (seen.contains(pre)) {
            return true;
        }
        if (cache[pre] == 1) {
            return false;
        }
        seen.add(pre);
        Set<Integer> nextCourses = graph.getOrDefault(pre, new HashSet<>());
        for (Integer course : nextCourses) {
            if (hasLoop(course, graph, seen)) {
                return true;
            }
            cache[course] = 1;
        }
        seen.remove(pre);
        cache[pre] = 1;
        return false;
    }
}

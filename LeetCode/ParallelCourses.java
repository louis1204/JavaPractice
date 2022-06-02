class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        // Construct a graph of prereq -> courses, and find all nodes that doesn't have prereqs
        int[] hasPrereq = new int[n + 1];
        boolean[] seen = new boolean[n + 1];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int[] r : relations) {
            List<Integer> existing = graph.getOrDefault(r[0], new ArrayList<>());
            existing.add(r[1]);
            graph.put(r[0], existing);
            hasPrereq[r[1]]++;
        }
        for (int i = 1; i < hasPrereq.length; i++) {
            if (hasPrereq[i] == 0) {
                List<Integer> existing = graph.getOrDefault(0, new ArrayList<>());
                existing.add(i);
                graph.put(0, existing);
            }
        }
        
        if (!graph.containsKey(0)) {
            return -1;
        }
        
        int sem = 0;
        Deque<Integer> curr = new LinkedList<>();
        curr.addAll(graph.get(0));
        
        while (!curr.isEmpty()) {
            Deque<Integer> next = new LinkedList<>();
            
            while (!curr.isEmpty()) {
                int course = curr.poll();
                if (seen[course]) {
                    continue;
                }
                seen[course] = true;
                for (int nextCourse : graph.getOrDefault(course, new ArrayList<>())) {
                    hasPrereq[nextCourse]--;
                    if (hasPrereq[nextCourse] == 0) {
                        next.offer(nextCourse);
                    }
                }
            }
            sem++;
            curr = next;
        }
        // Check if we have any prereqs remaining
        for (int pre : hasPrereq) {
            if (pre > 0) {
                return -1;
            }
        }
        return sem;
    }
}

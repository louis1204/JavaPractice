class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> parentToKids = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            List<Integer> existing = parentToKids.getOrDefault(ppid.get(i), new ArrayList());
            existing.add(pid.get(i));
            parentToKids.put(ppid.get(i), existing);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer next = queue.poll();
            res.add(next);
            queue.addAll(parentToKids.getOrDefault(next, new ArrayList<>()));
        }
        return res;
    }
}

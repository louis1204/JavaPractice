class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> roomsSet = new HashSet<>();
        List<Integer> bfs = new ArrayList<>();
        bfs.add(0);
        while (!bfs.isEmpty()) {
            List<Integer> next = new ArrayList<>();
            for (int key : bfs) {
                if (roomsSet.add(key)) {
                    next.addAll(rooms.get(key));
                }
            }
            bfs = next;
        }
        return rooms.size() == roomsSet.size();
    }
}

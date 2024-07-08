class Solution {
    public int findTheWinner(int n, int k) {
        // Can sim
        List<Integer> friends = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }
        int start = 0;
        // System.out.println(friends);
        while (friends.size() > 1) {
            // Find the index we will land at
            for (int i = 1; i < k; i++) { // Discount the start
                start++;
                if (start >= friends.size()) {
                    start = 0;
                }
            }
            friends.remove(start);
            if (start == friends.size()) {
                start = 0;
            }
        }
        return friends.get(0);
    }
}

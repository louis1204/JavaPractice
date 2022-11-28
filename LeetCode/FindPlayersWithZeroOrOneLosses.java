class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> lossCount = new HashMap<>();
        for (int[] match : matches) {
            if (!lossCount.containsKey(match[0])) {
                lossCount.put(match[0], 0);
            }
            lossCount.put(match[1], lossCount.getOrDefault(match[1], 0) + 1);
        }
        List<Integer> winners = new ArrayList<>();
        List<Integer> losers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : lossCount.entrySet()) {
            if (entry.getValue() == 0) {
                winners.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                losers.add(entry.getKey());
            }
        }
        winners.sort((a, b) -> a - b);
        losers.sort((a, b) -> a - b);
        return Arrays.asList(winners, losers);
    }
}

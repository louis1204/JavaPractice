class Solution {
    public int minCostII(int[][] costs) {
        // At most the amount of colors we need to pick from for each house is the lowest 3 to avoid
        // Clashing with prev and next?
        // Then we can recursively find the lowest for picking from the 3
        // Can also utilize memoization for smaller subsets of homes starting from the end
        // Can utilize greedy as well
        List<List<Pair<Integer, Integer>>> memo = new ArrayList<>();
        List<Pair<Integer, Integer>> first = new ArrayList<>();
        for (int color = 0; color < costs[0].length; color++) {
            first.add(new Pair<>(color, costs[0][color]));
        }
        first.sort((a, b) -> a.getValue() - b.getValue());
        memo.add(first);
        
        for (int house = 1; house < costs.length; house++) {
            List<Pair<Integer,Integer>> temp = new ArrayList<>();
            // For each color, find out the cost to paint it with the min cost of the prev
            for (int color = 0; color < costs[house].length; color++) {
                for (int i = 0; i < memo.get(house - 1).size(); i++) {
                    Pair<Integer, Integer> previousColorCost = memo.get(house - 1).get(i);
                    if (previousColorCost.getKey() != color) {
                        temp.add(new Pair<>(
                            color,
                            costs[house][color] + previousColorCost.getValue()));
                        break;
                    }
                }
            }
            temp.sort((a, b) -> a.getValue() - b.getValue());
            memo.add(temp);
        }
        return memo.get(memo.size() - 1).get(0).getValue();
    }
}

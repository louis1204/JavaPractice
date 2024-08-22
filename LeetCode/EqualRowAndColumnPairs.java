class Solution {
    public int equalPairs(int[][] grid) {
        // Create a set of the rows
        // Then go through the columns and see if there's any existing rows that are the same
        HashMap<List<Integer>, Integer> set = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                row.add(grid[i][j]);
            }
            set.put(row, set.getOrDefault(row, 0) + 1);
        }

        int res = 0;
        for (int col = 0; col < grid[0].length; col++) {
            List<Integer> temp = new ArrayList<>();
            for (int row = 0; row < grid.length; row++) {
                temp.add(grid[row][col]);
            }
            if (set.containsKey(temp)) {
                res += set.get(temp);
            }
        }
        return res;
    }
}

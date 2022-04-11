class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        // k = k % Math.max(m, n);
        // Just simulate
        while (k > 0) {
            //1. Move over one col
            //2. For the last column, move to the first column and down one
            //3. Move the bottom right corner to the top left
            int bottomRight = grid[m - 1][n - 1];
            int[] lastCol = new int[m];
            for (int i = 0; i < m; i++) {
                lastCol[i] = grid[i][n - 1];
            }
            // System.out.println(Arrays.toString(lastCol));
            // Move over one for all
            for (int col = n - 1; col > 0; col--) {
                for (int row = 0; row < m; row++) {
                    grid[row][col] = grid[row][col - 1];
                }
            }
            // printGrid(grid);
            // Set the last col to the first and down one
            for (int row = 1; row < lastCol.length; row++) {
                grid[row][0] = lastCol[row - 1];
            }
            // Move the bottom to top left
            grid[0][0] = bottomRight;
            k--;
        }
        // Convert to object list
        List<List<Integer>> res = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> temp = new ArrayList<>();
            for (int num : row) {
                temp.add(num);
            }
            res.add(temp);
        }
        return res;
    }
    
    private void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }
}

class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        // Was this the naive approach?
        // Do this recursively with backtracking?
        // We just need to find a good spot, we can use an array for row, column, and diagonal usage
        // Diagonal will be 2n - 1 size
        // How to index? Ratio is not the same
        // I want a discrete number
        // Say I want 1, 1 to map to 3 in a 4x4 like in the example
        // 2,1 3,2 are on the same diagonal
        // If nothing, we can just go through the previous placements and see if they are in the same diagonal
        // They are on the same diagonal if the difference of x and y are the same
        helper(new ArrayList<>(), 0, new boolean[n], n);
        return res;
    }
    
    private void helper(List<Pair<Integer, Integer>> queens, int row, boolean[] colUsed, int n) {
        if (row >= n) {
            res.add(toBoard(queens, n));
            return;
        }
        for (int col = 0; col < n; col++) {
            // Previous column is used up
            if (colUsed[col]) {
                continue;
            }
            // Previous diag used
            if (diagUsed(queens, row, col)) {
                continue;
            }
            // Otherwise we can try it out
            Pair<Integer, Integer> coord = new Pair<>(row, col);
            queens.add(coord);
            colUsed[col] = true;
            helper(queens, row + 1, colUsed, n);
            queens.remove(queens.size() - 1);
            colUsed[col] = false;
        }
    }
    
    private boolean diagUsed(List<Pair<Integer, Integer>> queens, int row, int col) {
        for (Pair<Integer, Integer> q : queens) {
            int oRow = q.getKey();
            int oCol = q.getValue();
            
            int rowDiff = Math.abs(row - oRow);
            int colDiff = Math.abs(col - oCol);
            if (rowDiff == colDiff) {
                return true;
            }
        }
        return false;
    }
    
    private List<String> toBoard(List<Pair<Integer, Integer>> queens, int n) {
        List<String> res = new ArrayList<>();
        for (Pair<Integer, Integer> q : queens) {
            int col = q.getValue();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == col) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}

class Solution {
    public int totalNQueens(int n) {
        // This is like the normal n queens with no need to convert to board
        return helper(new boolean[n], new HashSet<>(), new HashSet<>(), 0, n);
    }
    
    public int helper(boolean[] colUsed, HashSet<Integer> diagUsed, HashSet<Integer> inverseDiagUsed, int row, int n) {
        if (row == n) {
            return 1; // We found a valid way
        }
        int accum = 0;
        for (int col = 0; col < n; col++) {
            if (colUsed[col]) {
                continue;
            }
            int diag = col - row;
            int invDiag = row + col;
            if (diagUsed.contains(diag) || inverseDiagUsed.contains(invDiag)) {
                continue;
            }
            colUsed[col] = true;
            diagUsed.add(diag);
            inverseDiagUsed.add(invDiag);
            accum += helper(colUsed, diagUsed, inverseDiagUsed, row + 1, n);
            colUsed[col] = false;
            diagUsed.remove(diag);
            inverseDiagUsed.remove(invDiag);
        }
        return accum;
    }
}

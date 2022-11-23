class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> columns = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'
                    && (!rows.add(board[i][j]))) {
                    return false;
                }
                if (board[j][i] != '.'
                    && (!columns.add(board[j][i]))) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                if (!validateSubsquare(board, i, j)) {
                    return false;
                }
            }    
        }
        return true;
    }
    private boolean validateSubsquare(char[][] board, int i, int j) {
        Set<Character> nums = new HashSet<>();
        int origI = i;
        int origJ = j;
        int rowLim = i + 3;
        int colLim = j + 3;
        for (i = origI; i < rowLim; i++) {
            for (j = origJ; j < colLim; j++) {
                if (board[i][j] != '.'
                    && !nums.add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}

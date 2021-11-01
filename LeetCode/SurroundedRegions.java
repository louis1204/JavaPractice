class Solution {
    public void solve(char[][] board) {
        // Question boils down to flip all islands in the board that are not connected to the edge in some way
        // Can explore the edge and flip the connected islands to a certain letter, then go through the board again
        for (int i = 0; i < board.length; i++) {
            helper(board, i, 0);
            helper(board, i, board[i].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            helper(board, 0, i);
            helper(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void helper(char[][] board, int m, int n) {
        if (m < 0 || m >= board.length || n < 0 || n >= board[m].length) {
            return;
        }
        if (board[m][n] == 'X') {
            return;
        }
        // if we have an 'O'
        if (board[m][n] == 'O') {
            board[m][n] = 'Z';
            for (int[] dir : dirs) {
                helper(board, m + dir[0], n + dir[1]);
            }
        }
    }
}

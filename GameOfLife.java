class Solution {
    public void gameOfLife(int[][] board) {
        // 1:  < 2 -> 0
        // 1: 2-3 -> 1
        // 1: > 3 -> 0
        // 0: = 3 -> 1
        int[][] newBoard = new int[board.length + 2][board[0].length + 2];
        for (int i = 1; i < board.length + 1; i++) {
            for (int j = 1; j < board[0].length + 1; j++) {
                newBoard[i][j] = board[i - 1][j - 1];
            }
        }
        // Now that we copied over the board to the new board, we can ignore boundary since it's all 0
        for (int i = 1; i < board.length + 1; i++) {
            for (int j = 1; j < board[0].length + 1; j++) {
                int amountAlive = getAliveNeighs(newBoard, i, j);
                if (board[i - 1][j - 1] == 1) {
                    if (amountAlive < 2) {
                        board[i - 1][j - 1] = 0;
                    } else if (amountAlive >= 2 && amountAlive <= 3) {
                        board[i - 1][j - 1] = 1;
                    } else { // > 3
                        board[i - 1][j - 1] = 0;
                    }
                } else {
                    if (amountAlive == 3) {
                        board[i - 1][j - 1] = 1;
                    }
                }
            }
        }
    }
    
    private int getAliveNeighs(int[][] board, int i, int j) {
        int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1},
                                   {0, -1}, {0, 1},
                                   {1, -1}, {1, 0}, {1, 1}};
        int alive = 0;
        for (int[] dir : dirs) {
            if (board[i + dir[0]][j + dir[1]] == 1) {
                alive++;
            }
        }
        return alive;
    }
}

class Solution {
    public String tictactoe(int[][] moves) {
        // Can simulate
        int[][] board = new int[3][3];
        // 1 = A, 2 = B
        boolean aTurn = true;
        for (int[] move : moves) {
            board[move[0]][move[1]] = aTurn ? 1 : 2;
            aTurn = !aTurn;
        }
        // for (int[] b : board) {
        //     System.out.println(Arrays.toString(b));
        // }
        for (int row = 0; row < board.length; row++) {
            int aCount = 0;
            int bCount = 0;
            for (int col = 0; col < board.length; col++) {
                aCount += board[row][col] == 1 ? 1 : 0;
                bCount += board[row][col] == 2 ? 1 : 0;
            }
            if (aCount == 3) {
                return "A";
            }
            if (bCount == 3) {
                return "B";
            }
        }
        for (int col = 0; col < board.length; col++) {
            int aCount = 0;
            int bCount = 0;
            for (int row = 0; row < board.length; row++) {
                aCount += board[row][col] == 1 ? 1 : 0;
                bCount += board[row][col] == 2 ? 1 : 0;
            }
            if (aCount == 3) {
                return "A";
            }
            if (bCount == 3) {
                return "B";
            }
        }
        if (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) {
            return "A";
        }
        if (board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2) {
            return "B";
        }
        if (board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1) {
            return "A";
        }
        if (board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2) {
            return "B";
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}

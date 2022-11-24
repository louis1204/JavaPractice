class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) {
            return true;
        }
        char candidate = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == candidate) {
                    if (explore(board, i , j, word, 0, new boolean[board.length][board[0].length])) {
                        return true;
                    }
                }
            }   
        }
        return false;
    }

    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private boolean explore(char[][]board, int i, int j, String word, int wordPos, boolean[][] seen) {
        // Base case index out of range
        if (i < 0 || j < 0 || i >= seen.length || j >= seen[0].length) {
            return false;
        }
        // Base case not equal
        if (wordPos > word.length() - 1 || board[i][j] != word.charAt(wordPos)) {
            return false;
        }
        // Base case word pos is at the end and equal
        if (wordPos == word.length() - 1 && board[i][j] == word.charAt(wordPos)) {
            return true;
        }
        seen[i][j] = true;
        // Recursive cases
        for (int[] dir : dirs) {
            if (i + dir[0] < 0 || j + dir[1] < 0 || i + dir[0] >= seen.length || j + dir[1] >= seen[0].length) {
                continue;
            }
            if (!seen[i + dir[0]][j + dir[1]]
                    && explore(board, i + dir[0], j + dir[1], word, wordPos + 1, seen)) {
                return true;
            }
        }
        seen[i][j] = false;
        return false;
    }
}

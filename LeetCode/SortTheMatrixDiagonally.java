class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        // First do the left column
        for (int row = 0; row < mat.length; row++) {
            List<Integer> diag = new ArrayList<>();
            int col = 0;
            int tempRow = row;
            while (tempRow < mat.length && col < mat[0].length) {
                diag.add(mat[tempRow++][col++]);
            }
            diag.sort((a, b) -> a - b);
            col = 0;
            tempRow = row;
            while (tempRow < mat.length && col < mat[0].length) {
                res[tempRow][col] = diag.get(col);
                tempRow++;
                col++;
            }
        }
        
        // Do the top row
        for (int col = 1; col < mat[0].length; col++) {
            List<Integer> diag = new ArrayList<>();
            int row = 0;
            int tempCol = col;
            while (tempCol < mat[0].length && row < mat.length) {
                diag.add(mat[row++][tempCol++]);
            }
            diag.sort((a, b) -> a - b);
            row = 0;
            tempCol = col;
            while (tempCol < mat[0].length && row < mat.length) {
                res[row][tempCol] = diag.get(row);
                row++;
                tempCol++;
            }
        }
        return res;
    }
}

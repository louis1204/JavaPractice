class NumMatrix {
    // Have multiple BITs?
    int[][] BITS = null;
    int[][] matrix = null;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.BITS = new int[matrix.length][matrix.length == 0 ? 0 : matrix[0].length + 1];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int temp = col + 1;
                while (temp < BITS[0].length) {
                    BITS[row][temp] += matrix[row][col];
                    temp += temp & -temp;
                }
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        int temp = col + 1;
        while (temp < BITS[0].length) {
            BITS[row][temp] += diff;
            temp += temp & -temp;
        }
    }
    
    private int getSum(int row, int col) {
        int res = 0;
        col++;
        while (col > 0) {
            res += BITS[row][col];
            col -= col & -col;
        }
        return res;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (; row1 <= row2; row1++) {
            res += getSum(row1, col2) - getSum(row1, col1 - 1);
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */

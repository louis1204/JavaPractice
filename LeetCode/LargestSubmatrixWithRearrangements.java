class Solution {
    public int largestSubmatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[j][i] == 1) {
                    matrix[j][i] += matrix[j - 1][i];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(max, (j + 1) * matrix[i][matrix[i].length - j - 1]);
            }
        }
        return max;
    }
}

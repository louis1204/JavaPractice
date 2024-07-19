class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] maxRow = new int[matrix.length];
        Arrays.fill(maxRow, Integer.MAX_VALUE);
        int[] maxCol = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
                maxRow[i] = Math.min(maxRow[i], matrix[i][j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (maxCol[j] == matrix[i][j] && maxRow[i] == matrix[i][j]) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}

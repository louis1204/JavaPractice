class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // do binary search across the matrix
        // We can treat each cells index as a monotonically increasing sequence for each row
        // When we decode the number to cell
        // m = rows, n = cols
        // number = k
        // row access = k / cols
        // col access = k % cols
        int cols = matrix[0].length;
        int tail = 0;
        int head = matrix.length * matrix[0].length;
        while (tail <= head) {
            int mid = (tail + head) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if (row >= matrix.length || col >= matrix[0].length) {
                return false;
            }
            // System.out.print(tail + " " + head + " " + mid + " " + row + " ");
            // System.out.println(col);
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                tail = mid + 1;
            } else {
                head = mid - 1;
            }
        }
        return false;
    }
}

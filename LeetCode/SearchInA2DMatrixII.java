class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search on the rows
        for (int[] row : matrix) {
            if (find(row, target)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean find(int[] row, int target) {
        int lo = 0;
        int hi = row.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (row[mid] == target) {
                return true;
            }
            if (row[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
}

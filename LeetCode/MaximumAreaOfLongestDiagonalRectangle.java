class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int res = Integer.MIN_VALUE;
        double maxDiag = Float.MIN_VALUE;
        for (int[] dim : dimensions) {
            double diag = Math.sqrt(Math.pow(dim[0], 2) + Math.pow(dim[1], 2));
            // System.out.println("Diag " + Arrays.toString(dim) + " " + diag);
            if (diag == maxDiag) {
                res = Math.max(res, dim[0] * dim[1]);
            } else if (diag > maxDiag) {
                maxDiag = diag;
                res = dim[0] * dim[1];
            }
        }
        return res;
    }
}

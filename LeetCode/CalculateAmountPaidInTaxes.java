class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0.0;
        if (income == 0) {
            return res;
        }
        
        for (int i = 0; i < brackets.length; i++) {
            int upper = brackets[i][0];
            int percent = brackets[i][1];
            int lower = i == 0 ? 0 : brackets[i - 1][0];
            res += Math.min(upper - lower, income) * ((double)percent / (double)100);
            income -= (upper - lower);
            if (income <= 0) {
                break;
            }
        }
        return res;
    }
}

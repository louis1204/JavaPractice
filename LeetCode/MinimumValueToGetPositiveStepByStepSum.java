class Solution {
    public int minStartValue(int[] nums) {
        int startVal = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum < 0 && -sum + 1 > startVal) {
                startVal = -sum + 1;
            }
        }
        return startVal;
    }
}

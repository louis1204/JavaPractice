class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length + 1];
        for (int num : nums) {
            count[num]++;
        }
        int missing = 0;
        int d = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                missing = i;
            }
            if (count[i] == 2) {
                d = i;
            }
            if (missing != 0 && d != 0) {
                break;
            }
        }
        return new int[] {d, missing};
    }
}

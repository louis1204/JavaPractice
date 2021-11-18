class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Can utilize marking
        for (int num : nums) {
            if (num != -1) {
                while (nums[num - 1] != -1) {
                    int temp = nums[num - 1];
                    nums[num - 1] = -1;
                    num = temp;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] != -1) {
                res.add(i);
            }
        }
        return res;
    }
}

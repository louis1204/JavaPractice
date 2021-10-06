class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 1) {
                res.add(Math.abs(num));
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        return res;
    }
}

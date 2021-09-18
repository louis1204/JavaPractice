class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] nums = new int[1001];
        for (int num : nums1) {
            nums[num]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (nums[num] > 0) {
                res.add(num);
                nums[num]--;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}

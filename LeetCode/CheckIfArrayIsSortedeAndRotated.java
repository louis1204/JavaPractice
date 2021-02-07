class Solution {
    public boolean check(int[] nums) {
        int[] sort = new int[nums.length];
        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                break;
            }
        }
        int ptr = 0;
        for (int j = i; j < nums.length; j++) {
            sort[ptr++] = nums[j];
        }
        for (int j = 0; j < i; j++) {
            sort[ptr++] = nums[j];
        }
        // System.out.println(Arrays.toString(sort));
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        return Arrays.equals(nums, sort);
    }
}

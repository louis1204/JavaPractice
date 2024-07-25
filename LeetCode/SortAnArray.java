class Solution {
    public int[] sortArray(int[] nums) {
        ms(nums, 0, nums.length - 1);
        return nums;
    }

    private void ms(int[] nums, int start, int end) {
        if (start >= end || start >= nums.length) {
            return;
        }
        int mid = (start + end) / 2;
        ms(nums, start, mid);
        ms(nums, mid + 1, end);
        // Now we merge the 2 segments
        int firstSeg = start;
        int secondSeg = mid + 1;
        List<Integer> sorted = new ArrayList<>();
        while (firstSeg <= mid && secondSeg <= end) {
            if (nums[firstSeg] <= nums[secondSeg]) {
                sorted.add(nums[firstSeg]);
                firstSeg++;
            } else {
                sorted.add(nums[secondSeg]);
                secondSeg++;
            }
        }
        while (firstSeg <= mid) {
            sorted.add(nums[firstSeg]);
            firstSeg++;
        }
        while (secondSeg <= end) {
            sorted.add(nums[secondSeg]);
            secondSeg++;
        }
        int numsCounter = start;
        for (int s : sorted) {
            nums[numsCounter++] = s;
        }
    }
}

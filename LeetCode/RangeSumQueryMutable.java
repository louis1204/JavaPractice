class NumArray {
    int[] BIT = null;
    int[] nums = null;
    public NumArray(int[] nums) {
        BIT = new int[nums.length + 1];
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            init(i, nums[i]);
        }
    }
    
    public void init(int index, int val) {
        index++;
        while (index < BIT.length) {
            BIT[index] += val;
            index += index & -index;
        }
    }
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        init(index, diff);
    }
    
    public int sumRange(int left, int right) {
        int leftVal = getSum(left - 1);
        int rightVal = getSum(right);
        // System.out.println(Arrays.toString(BIT));
        // System.out.println(leftVal);
        // System.out.println(rightVal);
        return rightVal - leftVal;
    }
    
    private int getSum(int index) {
        int res = 0;
        index++;
        while (index > 0) {
            res += BIT[index];
            index -= index & -index;
        }
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

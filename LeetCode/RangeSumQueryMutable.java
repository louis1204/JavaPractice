class NumArray {
    // https://www.youtube.com/watch?v=uSFzHCZ4E-8
    int[] bit;
    int[] nums;
    
    public NumArray(int[] nums) {
        this.bit = new int[nums.length + 1]; // We add plus one since BIT is 1 indexed
        this.nums = nums; // We save the original to update based on diffs
        createBit(this.bit, nums);
        System.out.println(Arrays.toString(this.bit));
    }
    
    private void createBit(int[] bit, int[] nums) {
        // First populate
        for (int i = 0; i < nums.length; i++) {
            bit[i + 1] = nums[i];
        }
        // Update it's parents
        for (int i = 1; i < bit.length; i++) {
            int parent = i + (i & -i);
            if (parent < bit.length) {
                bit[parent] += bit[i];
            }
        }
    }
    
    public void update(int index, int val) {
        index += 1;
        int diff = val - this.nums[index - 1];
        this.nums[index - 1] = val;
        // int childInd = (index & -index) >> 1;
        // this.bit[index] += this.bit[childInd];
        // Update the index and all its parents
        while (index < this.bit.length) {
            this.bit[index] += diff;
            index += (index & -index);
        }
        // System.out.println(Arrays.toString(this.bit));
    }
    
    public int sumRange(int left, int right) {
        // We'd have to get the sum range from it's right and sub from its left
        return helper(right + 1) - helper(left);
    }
    
    private int helper(int endInd) {
        int sum = 0;
        while (endInd > 0) {
            sum += this.bit[endInd];
            endInd -= endInd & -endInd; // Remove its last bit
        }
        // System.out.println(sum);
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

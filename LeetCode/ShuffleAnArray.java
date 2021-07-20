class Solution {
    private int[] nums;
    List<Integer> origList = new ArrayList<>();
    private Random random = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
        for (int num : nums) {
            origList.add(num);
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = nums.length;
        int[] res = new int[n];
        List<Integer> clone = new ArrayList<>() {{
            addAll(origList);
        }};
        while (n > 0) {
            int next = random.nextInt(n);
            res[nums.length - n] = clone.get(next);
            n--;
            clone.remove(next);
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

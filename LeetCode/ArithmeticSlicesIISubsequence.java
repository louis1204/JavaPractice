class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        // For each slot maintain a few info, the num val, the diff to count of prev numbers with that diff
        // Then we can dynamically get the count of the diffs retroactively. And if the count is greater than 2, increase the result
        // Overall complexity is n^2
        int res = 0;
        List<Meta> dp = new ArrayList<>();
        dp.add(new Meta(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            Meta curr = new Meta(nums[i]);
            for (int j = 0; j < dp.size(); j++) {
                long longDiff = (long)curr.val - (long)dp.get(j).val;
                if (longDiff < Integer.MIN_VALUE || longDiff > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int) longDiff;
                int diffCount = dp.get(j).diffToCount.getOrDefault(diff, 0);
                res += diffCount;
                curr.diffToCount.put(diff, curr.diffToCount.getOrDefault(diff, 0) + diffCount + 1);
            }
            dp.add(curr);
        }
        // System.out.println(dp.toString());
        return res;
    }
    
    class Meta {
        int val = 0;
        HashMap<Integer, Integer> diffToCount = new HashMap<>();
        
        public Meta(int val) {
            this.val = val;
        }
        
        public String toString() {
            return "val->" + val + ", map->" + diffToCount.toString() + "\n";
        }
    }
}

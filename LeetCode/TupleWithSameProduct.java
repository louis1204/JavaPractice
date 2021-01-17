class Solution {
    public int tupleSameProduct(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> prodToInd = new HashMap<>();
        // When finding a valid one, increment res by 4
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int prod = nums[i] * nums[j];
                var existing = prodToInd.getOrDefault(prod, 0);
                res += existing * 8;
                existing++;
                prodToInd.put(prod, existing);
            }
        }
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         int prod = nums[i] * nums[j];
        //         var existing = prodToInd.get(prod);
        //         res += (existing.size() - 1) * 4;
        //     }
        // }
        return res;
    }
}

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        // Create a mapping of number to index
        // For each operation, get the index of the number, replace it with the operation's number, set that number's index
        int[] ind = new int[(int)10e6 + 1];
        Arrays.fill(ind, -1);
        for (int i = 0; i < nums.length; i++) {
            ind[nums[i]] = i;
        }
        for (int[] op : operations) {
            int i = ind[op[0]];
            nums[i] = op[1];
            ind[op[1]] = i;
        }
        return nums;
    }
}

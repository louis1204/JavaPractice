class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            int complement = k - num;
            if (seen.containsKey(complement) && seen.get(complement) > 0) {
                res++;
                seen.put(complement, seen.get(complement) - 1);
            } else {
                seen.put(num, seen.getOrDefault(num, 0) + 1);
            }
        }
        return res;
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> numToInd = new HashMap<>();
        
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            int complement = target - num;
            if (numToInd.containsKey(complement)) {
                return new int[]{numToInd.get(complement), i + 1};
            }
            numToInd.put(num, i + 1);
        }
        return new int[0]; // Shouldn't reach
    }
}

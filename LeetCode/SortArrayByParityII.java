class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        //swap
        Stack<Integer> misplacedEvens = new Stack<>();
        Stack<Integer> misplacedOdds = new Stack<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Misplaced odd
            if (i % 2 == 0 && nums[i] % 2 != 0) {
                if (!misplacedEvens.isEmpty()) {
                    int prevInd = misplacedEvens.pop();
                    int prev = nums[prevInd];
                    nums[prevInd] = nums[i];
                    nums[i] = prev;
                } else {
                    misplacedOdds.push(i);
                }
            }
            // Misplaced even
            if (i % 2 == 1 && nums[i] % 2 == 0) {
                if (!misplacedOdds.isEmpty()) {
                    int prevInd = misplacedOdds.pop();
                    int prev = nums[prevInd];
                    nums[prevInd] = nums[i];
                    nums[i] = prev;
                } else {
                    misplacedEvens.push(i);
                }
            }
        }
        return nums;
    }
}

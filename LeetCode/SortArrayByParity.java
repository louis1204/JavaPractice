class Solution {
    
    public int[] sortArrayByParity(int[] nums) {
        int evenPtr = nums.length - 1;
        evenPtr = getNextEven(nums, evenPtr);
        
        int oddPtr = 0;
        oddPtr = getNextOdd(nums, oddPtr);
        
        while (oddPtr < evenPtr) {
            int tempOdd = nums[oddPtr];
            nums[oddPtr] = nums[evenPtr];
            nums[evenPtr] = tempOdd;
            evenPtr = getNextEven(nums, evenPtr);
            oddPtr = getNextOdd(nums, oddPtr);
        }
        return nums;
    }
    
    private int getNextEven(int[] nums, int evenPtr) {
        while (evenPtr >= 0 && nums[evenPtr] % 2 != 0) {
            evenPtr--;
        }
        return evenPtr;
    }
    
    private int getNextOdd(int[] nums, int oddPtr) {
        while (oddPtr < nums.length && nums[oddPtr] % 2 == 0) {
            oddPtr++;
        }
        return oddPtr;
    }
}

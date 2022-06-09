class Solution {
    public int minSwaps(int[] data) {
        // Count the number of ones
        // Then do a 2 pointer approach as sliding window
        // First head and tail start at index 0
        // Increment tail until we reach the number of one's
        // as we increment tail, count the amount of 0's. This is the amount that we need to swap
        // From there, increment head and tail. If head is a 0, increment that count. If tail was a 0 and now a 1, decrement
        
        int numOnes = 0;
        for (int num : data) {
            numOnes += num;
        }
        
        // initialize
        int numZeros = 0;
        
        for (int i = 0; i < numOnes; i++) {
            if (data[i] == 0) {
                numZeros++;
            }
        }
        int head = numOnes;
        int tail = 1;
        
        int min = numZeros;
        
        while (head < data.length) {
            if (data[head] == 0) {
                numZeros++;
            }
            if (data[tail - 1] == 0) {
                numZeros--;
            }
            min = Math.min(min, numZeros);
            head++;
            tail++;
        }
        return min;
    }
}

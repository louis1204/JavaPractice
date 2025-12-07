class Solution {
    public int countOdds(int low, int high) {
        int len = high - low + 1;
        if (len % 2 == 0) {
            // 1, 2, 3, 4 -> 2
            return len / 2; // even amt return the length div 2
        }
        // odd amt
        // 1, 2 , 3 -> 2
        // 2, 3, 4 -> 1
        if (low % 2  == 0) {
            return len / 2;
        }
        return (len / 2) + 1;
    }
} // 3, 4, 5, 6, 7

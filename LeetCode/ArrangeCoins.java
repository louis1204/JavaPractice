class Solution {
    public int arrangeCoins(int n) {
        int row = 0;
        int prev = 1;
        while (n - prev >= 0) {
            n -= prev;
            prev = prev + 1;
            row++;
        }
        return row;
    }
}

// rows
// 1, 3, 6, 10, 15, 21, 28, 36, 45
// 1, 2, 3,  4,  5,  6,  7,  8,  9

class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            if (i + getRev(i) == num) {
                return true;
            }
        }
        return false;
    }
    
    private int getRev(int n) {
        int res = 0;
        while (n > 0) {
            res *= 10;
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}

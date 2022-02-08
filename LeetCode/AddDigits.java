class Solution {
    public int addDigits(int num) {
        //456
        //15
        //6
        //9875
        //29
        //11
        //2
        while (num >= 10) {
            int temp = 0;
            while (num > 0) {
                temp += num % 10;
                num /= 10;
            }
            num = temp;
        }
        return num;
    }
}

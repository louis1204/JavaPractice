class Solution {
    public int getLucky(String s, int k) {
        String digits = "";
        for (char c : s.toCharArray()) {
            digits += c - 'a' + 1;
        }
        int sum = 0;
        while (k > 0) {
            sum = 0;
            for (char c : digits.toCharArray()) {
                sum += c - '0';
            }
            digits = "" + sum;
            k--;
        }
        return sum;
    }
}

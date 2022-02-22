class Solution {
    public int titleToNumber(String columnTitle) {
        // Essentially a base 26 number system
        int res = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            res += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, columnTitle.length() - 1 - i);
        }
        return res;
    }
}

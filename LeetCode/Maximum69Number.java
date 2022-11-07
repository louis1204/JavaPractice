class Solution {
    public int maximum69Number (int num) {
        String stringVer = "" + num;
        for (int i = 0; i < stringVer.length(); i++) {
            if (stringVer.charAt(i) == '6') {
                return num + ((int) (3 * Math.pow(10, stringVer.length() - i - 1)));
            }
        }
        return num;
    }
}

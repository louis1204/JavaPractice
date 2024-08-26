class Solution {
    public int minFlips(int a, int b, int c) {
        String aString = Integer.toBinaryString(a);
        String bString = Integer.toBinaryString(b);
        String cString = Integer.toBinaryString(c);

        // Find the max size and pad with zeros
        int maxSize = Math.max(aString.length(), Math.max(bString.length(), cString.length()));
        while (aString.length() != maxSize) {
            aString = "0" + aString;
        }
        while (bString.length() != maxSize) {
            bString = "0" + bString;
        }
        while (cString.length() != maxSize) {
            cString = "0" + cString;
        }
        int flips = 0;

        // a = 1000
        // b = 0011
        // c = 0101
        for (int i = 0; i < cString.length(); i++) {
            if (cString.charAt(i) == '1' && aString.charAt(i) == '0' && bString.charAt(i) == '0') {
                flips++;
            } else if (cString.charAt(i) == '0' && aString.charAt(i) == '1' && bString.charAt(i) == '1') {
                flips += 2;
            } else if (cString.charAt(i) == '0' && (aString.charAt(i) == '1' || bString.charAt(i) == '1')) {
                flips++;
            }
        }
        return flips;
    }
}

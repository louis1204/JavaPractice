class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Create a set of divisors for the first string
        // Find divisors by testing different lengths
        HashSet<String> divisors = new HashSet<>();
        for (int length = 1; length <= str1.length(); length ++) {
            if (isDivisor(str1, str1.substring(0, length))) {
                divisors.add(str1.substring(0, length));
            }
        }
        // Work backwards for str2
        for (int length = str2.length(); length >= 1; length--) {
            if (isDivisor(str2, str2.substring(0, length)) && divisors.contains(str2.substring(0, length))) {
                return str2.substring(0, length);
            }
        }
        return "";
    }

    private boolean isDivisor(String str, String div) {
        int ind = 0;
        while (ind < str.length()) {
            if (ind + div.length() > str.length()) {
                return false;
            }
            if (str.substring(ind, ind + div.length()).equals(div)) {
                ind += div.length();
            } else {
                return false;
            }
        }
        return true;
    }
}

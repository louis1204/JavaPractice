class Solution {
    public int compress(char[] chars) {
        // Find where the current chars end
        // Find the length by where it starts with ends - starts
        // Have another pointer pointing to where we are in the array to write the result
        int start = 0;
        int end = 0;
        int write = 0;
        char curr = '\0';
        while (end < chars.length) {
            curr = chars[start];
            while (end < chars.length && chars[start] == chars[end]) {
                end++;
            }
            int amt = end - start;
            chars[write] = curr;
            write++;
            if (amt != 1) {
                for (char ch : ("" + amt).toCharArray()) {
                    chars[write++] = ch;
                }
            }
            start = end;
        }
        return write;
    }
}

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String sayPrev = countAndSay(n - 1);
        // Now for the string, count the digits
        char prevChar = '\0';
        int count = 0;
        StringBuilder res = new StringBuilder();
        for (char c : sayPrev.toCharArray()) {
            if (prevChar == '\0') {
                prevChar = c;
                count++;
                continue;
            }
            if (prevChar == c) {
                count++;
                continue;
            }
            res.append(count);
            res.append(prevChar);
            count = 1;
            prevChar = c;
        }
        res.append(count);
        res.append(prevChar);
        return res.toString();
    }
}

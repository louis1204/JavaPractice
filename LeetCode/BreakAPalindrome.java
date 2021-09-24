class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() < 2)
            return "";
        // Greed
        int head = 0;
        int tail = palindrome.length() - 1;
        StringBuilder sb = new StringBuilder(palindrome);
        while (head < tail) {
            if (sb.charAt(head) != 'a') {
                sb.setCharAt(head, 'a');
                return sb.toString();
            }
            head++;
            tail--;
        }
        sb.setCharAt(palindrome.length() - 1, 'b');
        return sb.toString();
    }
}

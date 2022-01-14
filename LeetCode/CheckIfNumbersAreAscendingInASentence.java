class Solution {
    public boolean areNumbersAscending(String ss) {
        String[] split = ss.split(" ");
        int lastSeen = 0;
        for (String s : split) {
            if (s.charAt(0) - '0' > 0 && s.charAt(0) - '0' <= 9) {
                if (Integer.parseInt(s) > lastSeen) {
                    lastSeen = Integer.parseInt(s);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

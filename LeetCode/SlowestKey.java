class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char slowestKey = keysPressed.charAt(0);
        int slowest = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int curr = releaseTimes[i] - releaseTimes[i - 1];
            if (curr == slowest) {
                if (slowestKey < keysPressed.charAt(i)) {
                    slowestKey = keysPressed.charAt(i);
                }
            } else if (curr > slowest) {
                slowestKey = keysPressed.charAt(i);
                slowest = curr;
            }
        }
        return slowestKey;
    }
}

class Solution {
    public int largestVariance(String s) {
        // Use a variation of kadane's algo for max subarray
        // pick 2 distinct letters as major and minor
        // treat major as +1 and minor as -1, rest as 0
        // keep a count of all the letters in the string s
        // Only update the global max if there is at least 1 minor
        // When we go negative, only allow to be zero'd out if there's still minors remaining
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        int globalMax = 0;
        for (int i = 0; i < alpha.length(); i++) {
            for (int j = 0; j < alpha.length(); j++) {
                if (j == i) {
                    continue;
                }
                int localMax = 0;
                char major = alpha.charAt(i);
                char minor = alpha.charAt(j);
                int remainingMinor = charCount[minor - 'a'];
                int majorCount = 0;
                int minorCount = 0;
                for (char c : s.toCharArray()) {
                    if (c == major) {
                        majorCount++;
                    } else if (c == minor) {
                        minorCount++;
                        remainingMinor--;
                    }
                    if (minorCount > majorCount && remainingMinor > 0) {
                        majorCount = 0;
                        minorCount = 0;
                    }
                    if (minorCount > 0) {
                        localMax = Math.max(localMax, majorCount - minorCount);
                        globalMax = Math.max(globalMax, localMax);
                    }
                }
            }
        }
        return globalMax;
    }
}

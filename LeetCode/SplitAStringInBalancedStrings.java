class Solution {
    public int balancedStringSplit(String s) {
        // Stack question
        // 2 stacks. one for R one for L
        // When we see R, if we can pop L and there's nothing left, we can count it
        // Similar for L
        // Otherwise, push
        // Just go iteratively
        int RCount = 0;
        int LCount = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                if (LCount > 0) {
                    LCount--;
                    if (LCount == 0) {
                        res++;
                    }
                } else {
                    RCount++;
                }
            } else if (c == 'L') {
                if (RCount > 0) {
                    RCount--;
                    if (RCount == 0) {
                        res++;
                    }
                } else {
                    LCount++;
                }
            }
        }
        return res;
    }
}

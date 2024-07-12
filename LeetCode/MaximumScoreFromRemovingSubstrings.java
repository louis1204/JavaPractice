class Solution {
    public int maximumGain(String s, int x, int y) {
        // Looks like we can do a greedy approach whichever is higher, we want to remove that
        // Proof is that assume we remove the lower one, then we will always be less than removing the higher one
        // Can removing the lower one result in a higher outcome? 
        // ab = 5, ba = 4.  aaaaababababbbbbb
        // Doesn't seem to matter

        // Just scan and remove the highers if any. If non, scan again, remove lowers
        // Repeat until nothing removed from either
        String higher, lower;
        int higherScore, lowerScore;
        if (x >= y) {
            higher = "ab";
            lower = "ba";
            higherScore = x;
            lowerScore = y;
        } else {
            higher = "ba";
            lower = "ab";
            higherScore = y;
            lowerScore = x;
        }

        boolean shouldRemoveHigher = true;
        Stack<Character> stack = new Stack<>();
        int score = 0;
        do {
            for (int i = 0; i < s.length(); i++) {
                if (stack.isEmpty()) {
                    stack.push(s.charAt(i));
                    continue;
                }
                char prev = stack.peek();
                if (shouldRemoveHigher) {
                    if (s.charAt(i) == higher.charAt(1) && prev == higher.charAt(0)) {
                        score += higherScore;
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                } else {
                    if (s.charAt(i) == lower.charAt(1) && prev == lower.charAt(0)) {
                        score += lowerScore;
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                }
            }
            if (!shouldRemoveHigher) {
                break;
            }
            shouldRemoveHigher = false;
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            s = sb.reverse().toString();
            // System.out.println(s);
        } while (true);
        return score;
    }
}

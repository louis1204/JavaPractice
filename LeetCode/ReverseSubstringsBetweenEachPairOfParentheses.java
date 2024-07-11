class Solution {
    public String reverseParentheses(String s) {
        // Create a stack to find the end parenths to the start index
        // When the end is found, add the start and end to a queue
        // Go through the queue and reverse whatever is from start to end
        // Remove the parenths and return the res
        Stack<Integer> starts = new Stack<>();
        Deque<int[]> startEnds = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                starts.push(i);
            }
            if (ch == ')') {
                int startInd = starts.pop();
                startEnds.offer(new int[] {startInd, i});
            }
        }
        StringBuilder sb = new StringBuilder(s);
        boolean isFlipped = false;
        // System.out.println(sb);
        while (!startEnds.isEmpty()) {
            int[] curr = startEnds.poll();
            sb = flip(sb, curr[0], curr[1] + 1);
            // System.out.println(sb);
        }
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == ')' || sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }

    private StringBuilder flip(StringBuilder sb, int start, int end) {
        String first = sb.substring(0, start);
        String middle = sb.substring(start, end);
        String last = sb.substring(end, sb.length());
        StringBuilder temp = new StringBuilder(middle);
        temp = temp.reverse();
        return new StringBuilder(first + temp.toString() + last);
    }
}

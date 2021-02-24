class Solution {
    public int scoreOfParentheses(String S) {
        // Have a stack and when we empty it out we add to a sum
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(-1);
                continue;
            }
            int curr = 0;
            while (stack.peek() != -1) {
                curr += stack.pop();
            }
            stack.pop(); // pop the -1
            if (curr == 0) {
                stack.push(1);
            } else {
                stack.push(2 * curr);
            }
        }
        // Sum up the stack
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}

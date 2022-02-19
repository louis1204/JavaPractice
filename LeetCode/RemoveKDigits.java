class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length() || "0".equals(num)) {
            return "0";
        }
        // Just always gotta look at the max left numbers
        Stack<Integer> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c - '0');
                continue;
            }
            int curr = c - '0';
            while (!stack.isEmpty() && curr < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(curr);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        while (!res.isEmpty() && res.charAt(0) == '0') {
            res = res.substring(1);
        }
        return res.isEmpty() ? "0" : res;
    }
}

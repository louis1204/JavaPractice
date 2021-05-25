class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        HashSet<String> ops = new HashSet<>() {{
            add("+");
            add("-");
            add("/");
            add("*");
        }};
        for (String s : tokens) {
            if (ops.contains(s)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if ("+".equals(s)) {
                    stack.push(num1 + num2);
                }
                if ("-".equals(s)) {
                    stack.push(num2 - num1);
                }
                if ("*".equals(s)) {
                    stack.push(num1 * num2);
                }
                if ("/".equals(s)) {
                    stack.push(num2 / num1);
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}

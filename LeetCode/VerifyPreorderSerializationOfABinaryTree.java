class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] split = preorder.split(",");
        // When we get the double # we can pop out the last number
        // 9,3,4,#,#,1,#,#,2,#,6,#,#
        // 9,3,#,1,#,#,2,#,6,#,#
        // 9,3,#,#,2,#,6,#,#
        // 9,2,#,6,#,#
        // 9,2,#,#
        // 9,

        Stack<String> stack = new Stack<>();
        stack.push(split[0]);
        for (int i = 1; i < split.length; i++) {
            if (stack.isEmpty()) {
                return false;
            }
            String last = stack.peek();
            String next = split[i];
            if (last.equals("#") && last.equals(next)) {
                while ("#".equals(last)) {
                    if (stack.size() < 2) {
                        return false;
                    }
                    stack.pop();
                    if ("#".equals(stack.peek())) {
                        return false;
                    }
                    stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    last = stack.peek();
                }
                stack.push("#");
            } else {
                stack.push(next);
            }
            // System.out.println(stack.toString());
        }
        // System.out.println(stack.toString());
        return stack.size() == 1 && "#".equals(stack.get(0));
    }
}

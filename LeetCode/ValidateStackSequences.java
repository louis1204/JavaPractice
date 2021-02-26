class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return true;
        }
        int ptr1 = 0;
        int ptr2 = 0;
        Stack<Integer> stack = new Stack<>();
        while (ptr2 < popped.length && ptr1 < pushed.length) {
            // Stack empty and both equal
            if (stack.isEmpty() && popped[ptr2] == pushed[ptr1]) {
                ptr1++;
                ptr2++;
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(pushed[ptr1++]);
                continue;
            }
            if (popped[ptr2] == stack.peek()) {
                stack.pop();
                ptr2++;
            } else {
                stack.push(pushed[ptr1++]);
            }
        }
        while (ptr2 < popped.length) {
            if (popped[ptr2] == stack.peek()) {
                ptr2++;
                stack.pop();
            } else {
                break;
            }
        }
        return stack.isEmpty();
    }
}

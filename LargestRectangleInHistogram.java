class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i == 0) {
                stack.push(i);
                continue;
            }
            int curr = heights[i];
            while (stack.peek() != -1 && curr < heights[stack.peek()]) {
                int pop = stack.pop();
                max = Math.max(max, heights[pop] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        // We reached the end
        while (stack.peek() != -1) {
            int pop = stack.pop();
            max = Math.max(max, heights[pop] * (heights.length - stack.peek() - 1));
        }
        return max;
    }
}

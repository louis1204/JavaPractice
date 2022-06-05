class Solution {
    public int totalSteps(int[] nums) {
        // Go forward and use a stack
        Stack<int[]> stack = new Stack<>(); // [number, steps to make increasing]
        stack.push(new int[]{nums[0], 0});
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            int steps = 0;
            while (!stack.isEmpty() && stack.peek()[0] <= nums[i]) {
                steps = Math.max(stack.peek()[1], steps);
                stack.pop();
            }
            if (stack.isEmpty()) {
                steps = 0;
            } else {
                steps++;
            }
            max = Math.max(max, steps);
            stack.push(new int[] {nums[i], steps});
        }
        return max;
    }
}

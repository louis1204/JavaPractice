class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Can use a monotonic stack to construct the next greatest map
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> nextGreatest = new HashMap<>();
        for (int num : nums2) {
            if(stack.isEmpty()) {
                stack.add(num);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreatest.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nextGreatest.containsKey(nums1[i])) {
                nums1[i] = nextGreatest.get(nums1[i]);
            } else {
                nums1[i] = -1;
            }
        }
        return nums1;
    }
}

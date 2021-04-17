class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().getKey().equals(c)) {
                var prev = stack.pop();
                if (prev.getValue() + 1 != k) {
                    stack.push(new Pair<>(c, prev.getValue() + 1));
                }
            } else {
                stack.push(new Pair<>(c, 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            for (int i = 0; i < stack.peek().getValue(); i++) {
                sb.insert(0, stack.peek().getKey());
            }
            stack.pop();
        }
        return sb.toString();
    }
}

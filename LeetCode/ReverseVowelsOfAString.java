class Solution {
    public String reverseVowels(String s) {
        // use a queue for constanants, stack for vowels
        Deque<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        HashSet<Character> vowels = new HashSet<>();
        vowels.addAll(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                stack.push(c);
            } else {
                queue.offer(c);
            }
        }

        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                sb.append(stack.pop());
            } else {
                sb.append(queue.poll());
            }
        }
        return sb.toString();
    }
}

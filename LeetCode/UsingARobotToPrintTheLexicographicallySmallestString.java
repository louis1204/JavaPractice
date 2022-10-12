class Solution {
    Deque<Character> s = new LinkedList<>();
    StringBuilder p = new StringBuilder();
    Stack<Character> t = new Stack();
    
    public String robotWithString(String str) {
        // Looks like we can approach this greedily
        // Whatever is the smallest character, we want those written on p first
        // Then get the next smallest character in s or the last character of t
        // Give that to the robot, and continue
        int[] charCount = new int[26];
        for (char ch : str.toCharArray()) {
            charCount[ch - 'a']++;
            s.offer(ch);
        }
        while (!s.isEmpty()) {
            char lowest = getLowest(charCount);
            if (t.isEmpty() || t.peek() > lowest) {
                char ch = s.poll();
                t.push(ch);
                charCount[ch - 'a']--;
                continue;
            }
            if (t.peek() <= lowest) {
                p.append(t.pop());
            }
        }
        while (!t.isEmpty()) {
            p.append(t.pop());
        }
        return p.toString();
    }
    
    private char getLowest(int[] charCount) {
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 0) {
                return (char) ('a' + i);
            }
        }
        return '\0';
    }
}

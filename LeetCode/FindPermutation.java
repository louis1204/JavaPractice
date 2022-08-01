class Solution {
    public int[] findPermutation(String s) {
        // When we encounter I, it needs to be represented as (i, i + 1)
        // D (i + 1, i)
        // DI (i + 1, i, i + 2)
        // ID (i, i + 2, i + 1)
        // II (i, i + 1, i + 2)
        // DD (i + 2, i + 1, i)
        // Always be increasing, but if we encounter a sequence of D's, we need that segment to be reversed
        // Until the next i
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int counter = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'I' && !stack.isEmpty()) {
                res.add(counter);
                while (!stack.isEmpty()) {
                    res.add(stack.pop());
                }
                counter++;
                continue;
            }
            if (ch == 'I') {
                res.add(counter);
                counter++;
                continue;
            }
            stack.push(counter);
            counter++;
        }
        stack.push(counter);
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        int[] asList = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            asList[i] = res.get(i);
        }
        return asList;
    }
}

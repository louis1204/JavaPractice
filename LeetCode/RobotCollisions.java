class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<int[]> sorted = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            sorted.add(new int[] {i, positions[i], healths[i], directions.charAt(i) == 'L' ? 0 : 1});
        }
        sorted.sort((a, b) -> a[1] - b[1]);
        // Need to know the direction of the last bot, and its health
        // Use array of {index, pos, health, dir}
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < sorted.size(); i++) {
            int[] bot = sorted.get(i);
            // System.out.println(Arrays.toString(bot));
            int dir = bot[3];
            if (stack.isEmpty()) {
                stack.push(bot);
            } else {
                // See if we collide
                int[] prevBot = stack.peek();
                // System.out.println("Prev bot " + Arrays.toString(prevBot));
                int prevDir = prevBot[3];
                if (prevDir == 1 && dir == 0) {
                    // We got a collision
                    if (prevBot[2] == bot[2]) {
                        // Same health
                        stack.pop();
                    } else if (prevBot[2] < bot[2]) {
                        // Current is stronger
                        stack.pop();
                        bot[2] -= 1;
                        i--; // repeat  this bot for the previous entry in the stack
                    } else {
                        // Prev is stronger
                        prevBot[2]--;
                        if (prevBot[1] <= 0) {
                            stack.pop();
                        }
                    }
                } else {
                    // Same direction
                    stack.push(bot);
                }
            }
        }
        // Finally aggregate into list, sort and return the result with just health
        List<int[]> finalResult = new ArrayList<>();
        while (!stack.isEmpty()) {
            finalResult.add(stack.pop());
        }
        finalResult.sort((a, b) -> a[0] - b[0]);
        return finalResult.stream().map(a -> a[2]).collect(Collectors.toList());
    }
}

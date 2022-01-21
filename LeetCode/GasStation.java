class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // We can simulate, n2 solution, will probably be TLE
        // Can use a memo with the highest amount of gas at that point
        // If we encounter a gas with lower than the highest, then we can disregard
        // otherwise we update the highest gas at that point and explore
        int[] highestGas = new int[gas.length];
        
        for (int start = 0; start < gas.length; start++) {
            // System.out.println("Start:" + start + "\n");
            int currGas = gas[start];
            int curr = start;
            // Can we even go?
            // System.out.print(currGas + ", ");
            if (currGas >= cost[curr] && currGas > highestGas[curr]) {
                highestGas[curr] = currGas;
                currGas -= cost[curr];
                curr = (curr + 1) % gas.length;
                currGas += gas[curr];
            } else {
                continue;
            }
            // Can we loop?
            while (curr != start && currGas >= cost[curr] && currGas > highestGas[curr]) {
                // System.out.print(currGas + ", ");
                highestGas[curr] = currGas;
                currGas -= cost[curr];
                curr = (curr + 1) % gas.length;
                currGas += gas[curr];
            }
            if (curr == start) {
                return start;
            }
        }
        // System.out.println(Arrays.toString(highestGas));
        return -1;
    }
}

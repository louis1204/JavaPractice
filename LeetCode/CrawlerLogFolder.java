class Solution {
    public int minOperations(String[] logs) {
        // Start at the main folder
        // if we hit ../,  decrement the dist from main if not at main
        // ./ do nothing
        // x/ + 1 tp dist
        int dist = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                dist = Math.max(0, dist - 1);
            } else if ("./".equals(log)) {
                continue;
            } else {
                dist += 1;
            }
        }
        return dist;
    }
}

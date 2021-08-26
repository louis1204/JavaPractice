class Solution {
    public boolean judgeSquareSum(int c) {
        int limit = 46261;
        HashSet<Integer> prev = new HashSet<>();
        for (int i = 0; i <= limit; i++) {
            int pow = i * i;
            prev.add(pow);
            if (prev.contains(c - pow)) {
                return true;
            }
        }
        return false;
    }
}

class Solution {
    private static int HALF_INT_MIN = -1073741824;// -2**30;
    
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        int negCount = 0;
        if (dividend > 0) {
            negCount++;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negCount++;
            divisor = -divisor;
        }
        List<Integer> doubles = new ArrayList<>();
        doubles.add(divisor);
        while (doubles.get(doubles.size() - 1) >= dividend) {
            if (doubles.get(doubles.size() - 1) < HALF_INT_MIN) {
                break;
            }
            int curr = doubles.get(doubles.size() - 1) + doubles.get(doubles.size() - 1);
            doubles.add(curr);
        }
        int res = 0;
        // System.out.println(doubles.toString());
        while (dividend <= 0 && !doubles.isEmpty()) {
            if (doubles.get(doubles.size() - 1) >= dividend) {
                // System.out.println(doubles.get(doubles.size() - 1));
                dividend -= doubles.get(doubles.size() - 1);
                res -= Math.pow(2, doubles.size() - 1);
            }
            doubles.remove(doubles.size() - 1);
        }
        // System.out.println(doubles.toString());
        return negCount == 1 ? res : -res;
    }
}

class Solution {
    public int[] countBits(int n) {
        // start with 1 and shift left until > n
        // Set these numbers to be 1 in our result array
        // For all other numbers that don't fall in this range of numbers,
        // Look at the number with only 1 bit set, then add up the rest of the 1 bits set that would fit until we hit zero
        int[] res = new int[n + 1];
        int mask = 1;
        TreeSet<Integer> powsOfTwo = new TreeSet<>();
        
        while (mask < res.length) {
            res[mask] = 1;
            powsOfTwo.add(mask);
            mask <<= 1;
        }
        // System.out.println(powsOfTwo.toString());
        for (int i = 3; i <= n; i++) {
            if (res[i] == 1) {
                continue;
            }
            int num = i;
            int count = 0;
            while (num > 0) {
                num -= powsOfTwo.floor(num);
                count++;
            }
            res[i] = count;
        }
        return res;
    }
}

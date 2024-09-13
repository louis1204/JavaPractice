class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // Can we do some kind of prefix sum type of deal?
        // When we do an xor between 2 numbers it will be 1 if different o.w. 0
        // So we just need to look at the last 2 numbers and see if there was a change?
        // How do we remove the first part before the starting number then?
        // Use the property x ^ y ^ x = y
        // So when we want to know what the result of a ^ b ^ c ^ d ^ e
        // And we just want the range from c ^ e
        // Take the prefix sum ending at e, x
        // Now we need to take out a ^ b, y
        // Since we've already xored it with the range we want, just xor it again
        //  x ^ y
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = arr[i] ^ prefix[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = prefix[queries[i][1]];
            if (queries[i][0] > 0) {
                res[i] ^= prefix[queries[i][0] - 1];
            }
        }
        return res;
    }
}

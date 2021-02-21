class Solution {
    public int[] minOperations(String boxes) {
        // n2 soln?
        int[] res = new int[boxes.length()];
        for (int i = 0; i < res.length; i++) {
            int temp = 0;
            for (int j = 0; j < boxes.length(); j++) {
                if (boxes.charAt(j) == '1') {
                    temp += Math.abs(j - i);
                }
            }
            res[i] = temp;
        }
        return res;
    }
}

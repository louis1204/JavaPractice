class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == c) {
                pos.add(i);
            }
        }
        int[] res = new int[s.length()];
        int resPtr = 0;
        int posPtr = 0;
        while (resPtr < res.length) {
            if (posPtr == pos.size() - 1) {
                res[resPtr] = Math.abs(pos.get(posPtr) - resPtr);
                resPtr++;
                continue;
            }
            if (Math.abs(pos.get(posPtr + 1) - resPtr) < Math.abs(pos.get(posPtr) - resPtr)) {
                posPtr++;
            }
            res[resPtr] = Math.abs(pos.get(posPtr) - resPtr);
            resPtr++;
        }
        return res;
    }
}

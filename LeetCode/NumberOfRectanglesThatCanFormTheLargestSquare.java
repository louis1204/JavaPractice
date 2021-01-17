class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxSide = Integer.MIN_VALUE;
        for (int[] side : rectangles) {
            int temp = Math.min(side[0], side[1]);
            maxSide = Math.max(maxSide, temp);
        }
        int count = 0;
        for (int[] side : rectangles) {
            if (maxSide <= side[0] && maxSide <= side[1]) {
                count++;
            }
        }
        return count;
    }
}

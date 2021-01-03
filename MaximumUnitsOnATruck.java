class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort by units per box, greedily pick as much boxes as possible
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        int ptr = 0;
        // for (int[] box : boxTypes) {
        // System.out.println(Arrays.toString(box));
        // }
        while (truckSize > 0 && ptr < boxTypes.length) {
            int amountTakable = Math.min(truckSize, boxTypes[ptr][0]);
            res += boxTypes[ptr][1] * amountTakable;
            truckSize -= amountTakable;
            ptr++;
        }
        return res;
    }
}

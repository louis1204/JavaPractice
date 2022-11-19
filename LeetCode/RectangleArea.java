class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // Get the total area, then subtract the overlapping area
        // Iterate each point then check if there's overlap or not
        // If there's overlap, get the overlapping area
        // This is a 10^8 algo which should be ok
        int overlapArea = 0;
        for (int x = ax1; x < ax2; x++) {
            if (hasXOverlap(bx1, bx2, x) && hasYOverlap(ay1, ay2, by1, by2)) {
                int temp = Math.min(ay2, by2) - Math.max(ay1, by1);
                overlapArea += temp;
                // System.out.println("X: " + x);
                // System.out.println("temp: " + temp);
                // System.out.println("overlapArea: " + overlapArea);
            }
        }
        int area1 = (ay2 - ay1) * (ax2 - ax1);
        int area2 = (by2 - by1) * (bx2 - bx1);
        // System.out.println(area1);
        // System.out.println(area2);
        // System.out.println(overlapArea);
        return area1 + area2 - overlapArea;
    }

    private boolean hasXOverlap(int bx1, int bx2, int x) {
        // Overlap happens when any part of y is contained in the other rectangle's y's on that x
        return x < bx2 && x >= bx1;
    }

    private boolean hasYOverlap(int ay1, int ay2, int by1, int by2) {
        // Overlap happens when any part of y is contained in the other rectangle's y's on that x
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        list.add(new Pair<>(ay1, ay2));
        list.add(new Pair<>(by1, by2));
        list.sort((a, b) -> a.getKey() - b.getKey());
        return list.get(1).getKey() < list.get(0).getValue();
    }
}

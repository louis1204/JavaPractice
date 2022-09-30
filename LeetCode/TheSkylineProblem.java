class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // Create a list of points with denoting as start or end
        // Sort the list by their x values, y's and isEnd or not
        // Create a PQ with just 0
        // When we encounter a start insert in the PQ and if the max
        // changes add to res
        // When we encounter an end, remove from the PQ, if max changes
        // Add x with new max y
        List<Point> points = new ArrayList<>();
        constructPoints(buildings, points);
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a,b) -> b - a);
        PQ.add(0);
        List<List<Integer>> res = new ArrayList<>();
        int prevMax = 0;
        for (Point p : points) {
            if (p.isStart) {
                PQ.add(p.y);
                if (PQ.peek() > prevMax) {
                    prevMax = PQ.peek();
                    res.add(Arrays.asList(p.x, prevMax));
                }
            } else {
                PQ.remove(p.y);
                if (PQ.peek() != prevMax) {
                    prevMax = PQ.peek();
                    res.add(Arrays.asList(p.x, prevMax));
                }
            }
        }
        return res;
    }
    
    private void constructPoints(int[][] buildings, List<Point> points) {
        for (int[] b : buildings) {
            points.add(new Point(true, b[0], b[2]));
            points.add(new Point(false, b[1], b[2]));
        }
        points.sort((a, b) -> {
            //first compare by x.
            //If they are same then use this logic
            //if two starts are compared then higher height building should be picked first
            //if two ends are compared then lower height building should be picked first
            //if one start and end is compared then start should appear before end
            if (a.x != b.x) {
                return a.x - b.x;
            } else {
                return (a.isStart ? -a.y : a.y) - (b.isStart ? -b.y : b.y);
            }
        });
    }
    private class Point {
        boolean isStart;
        int x;
        int y;
        public Point(boolean isStart, int x, int y) {
            this.isStart = isStart;
            this.x = x;
            this.y = y;
        }
    }
}

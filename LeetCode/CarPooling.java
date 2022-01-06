class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Just simulate for each trip
        // Have a queue to hold dropoff points, otherwise take the trip
        PriorityQueue<int[]> dropOff = new PriorityQueue<>((a, b) -> a[0] - b[0]); // location, amount to release, need a heap with min location
        int inCar = 0;
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[2] - b[2];
                }
                return a[1] - b[1];
            }
        });
        for (int[] trip : trips) {
            while (!dropOff.isEmpty() && dropOff.peek()[0] <= trip[1]) {
                inCar -= dropOff.poll()[1];
            }
            inCar += trip[0];
            dropOff.offer(new int[] {trip[2], trip[0]});
            if (inCar > capacity) {
                return false;
            }
        }
        return true;
    }
}

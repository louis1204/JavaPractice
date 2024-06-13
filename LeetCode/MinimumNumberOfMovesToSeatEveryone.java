class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        // Could I just sort both and get the diff of each cell?
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += (int)Math.abs(seats[i] - students[i]);
        }
        return res;
    }
}

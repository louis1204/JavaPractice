class Solution {
    public int passThePillow(int n, int time) {
        // Just sim
        int place = 1;
        boolean forward = true;
        for (int i = 1; i <= time; i++) {
            if (forward == true) {
                place++;
            } else {
                place--;
            }
            // Check bounds
            if (place == n) {
                forward = false;
            }
            if (place == 1) {
                forward = true;
            }
        }
        return place;
    }
}

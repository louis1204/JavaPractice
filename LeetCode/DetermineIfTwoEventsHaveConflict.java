class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        String event1Start = event1[0];
        String event1End = event1[1];
        String event2Start = event2[0];
        String event2End = event2[1];
        if (event1Start.compareTo(event2Start) == 0) {
            // Starts at the same time
            return true;
        }
        if (event1Start.compareTo(event2Start) < 0) {
            // Event 1 goes first
            return event1End.compareTo(event2Start) >= 0;
        }
        return event2End.compareTo(event1Start) >= 0;
    }
}

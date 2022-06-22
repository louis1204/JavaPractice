class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        // Doesn't look like we are guaranteed that the start times are sorted, so we can do that first
        // Then we have a pointer for each person
        // If there is overlap and it fits the duration, return the earliest start time and end time
        // Increment one counter if the current timeslot is less
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int ptr1 = 0, ptr2 = 0;
        
        while (ptr1 < slots1.length && ptr2 < slots2.length) {
            int[] overlap = getOverlap(slots1[ptr1], slots2[ptr2]);
            // Overlap
            if (overlap != null) {
                if (overlap[1] - overlap[0] >= duration) {
                    return Arrays.asList(overlap[0], overlap[0] + duration);
                }
            }
            // There's no overlap or the overlap was not good
            // Increment the lower bound
            if (slots1[ptr1][1] <= slots2[ptr2][1]) {
                ptr1++;
            } else {
                ptr2++;
            }
        }
        return Arrays.asList();
    }
    
    private int[] getOverlap(int[] slot1, int[] slot2) {
        int[] overlap = new int[] {Math.max(slot1[0], slot2[0]), Math.min(slot1[1], slot2[1])};
        // System.out.println(Arrays.toString(overlap));
        // Check if it's valid
        if (overlap[1] < overlap[0]) {
            return null;
        }
        // Check if it's in both slot1 and slot2
        if (overlap[0] >= slot1[0]
                && overlap[0] >= slot2[0]
                && overlap[1] <= slot1[1]
                && overlap[1] <= slot2[1]) {
            return overlap;
        }
        return null;
    }
}

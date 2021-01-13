class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Sort and two pointer approach?
        boolean[] used = new boolean[people.length];
        Arrays.sort(people);
        int ptr1 = 0;
        int ptr2 = people.length - 1;
        int boats = 0;
        while (ptr1 < ptr2) {
            if (people[ptr1] + people[ptr2] <= limit) {
                used[ptr1++] = true;
                used[ptr2--] = true;
                boats++;
                continue;
            }
            ptr2--;
        }
        for (boolean isUsed : used) {
            if (!isUsed) {
                boats++;
            }
        }
        return boats;
    }
}

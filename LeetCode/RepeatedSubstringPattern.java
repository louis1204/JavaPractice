class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // Using substring size, simulate?
        for (int size = 1; size < s.length(); size++) {
            // check if it is a size divisible by s.length
            if (s.length() % size != 0) {
                continue;
            }
            String sub = s.substring(0, size);
            int ind = size;
            for (; ind < s.length(); ind += size) {
                String nextSub = s.substring(ind, ind + size);
                if (!nextSub.equals(sub)) {
                    break;
                }
            }
            if (ind >= s.length()) {
                return true;
            }
        }
        return false;
    }
}

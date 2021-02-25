class Solution {
    class Pos implements Comparable {
        int pos;
        int val;
        
        public Pos(int pos, int val) {
            this.pos = pos;
            this.val = val;
        }
        
        @Override
        public int compareTo(Object o) {
            Pos other = (Pos) o;
            return this.val - other.val;
        }
    }
    
    public int findUnsortedSubarray(int[] nums) {
        List<Pos> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new Pos(i, nums[i]));
        }
        list.sort((a, b) -> a.compareTo(b));
        int first = 0;
        int last = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).pos != i) {
                first = i;
                break;
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).pos != i) {
                last = i;
                break;
            }
        }
        if (first == last) {
            return 0;
        }
        return last - first + 1;
    }
}

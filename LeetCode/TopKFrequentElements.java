class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Point> list = new ArrayList<>();
        HashMap<Integer, Point> cache = new HashMap<>();
        for (int num : nums) {
            if (cache.containsKey(num)) {
                Point existing = cache.get(num);
                existing.times++;
                cache.put(num, existing);
            } else {
                Point newPoint = new Point(num);
                cache.put(num, newPoint);
                list.add(newPoint);
            }
        }
        list.sort((a, b) -> b.times - a.times);
        // System.out.println(list.toString());
        int[] res = new int[k];
        int ptr = 0;
        while (k > 0) {
            res[ptr] = list.get(ptr).val;
            k--;
            ptr++;
        }
        return res;
    }
    
    class Point {
        int val;
        int times = 1;
        
        public Point(int val) {
            this.val = val;
        }
        
        @Override
        public String toString() {
            return "{" + val + ", " + times + "}";
        }
    }
}

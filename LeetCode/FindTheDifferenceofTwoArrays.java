class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set2.add(n);
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for (int num : nums1) {
            if (!set2.contains(num)) {
                res.get(0).add(num);
                set2.add(num);
            }
        }
        for (int num : nums2) {
            if (!set1.contains(num)) {
                res.get(1).add(num);
                set1.add(num);
            }
        }
        return res;
    }
}

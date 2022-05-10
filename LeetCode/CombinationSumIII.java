class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // dp approach
        // Iterate from 1 to k
        // Save what n - the num is
        // Then do it again, and sub from the 1 numbers that doesn't contain the curr
        // Then do it again, until we hit k
        // How to check if the previous doesn't contain curr?
        // We need a mapping of number of nums -> Set of nums -> its sum
        // If we go over, n then we disregard
        HashMap<Integer, HashMap<HashSet<Integer>, Integer>> dp = new HashMap<>();
        for (int i = 1; i <= 9; i++) {
            // initialize with the single number
            if (i <= n) {
                HashMap<HashSet<Integer>, Integer> map = dp.getOrDefault(1, new HashMap<>());
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                map.put(set, i);
                dp.put(1, map);
            }
        }
        for (int i = 2; i <= k; i++) {
            HashMap<HashSet<Integer>, Integer> prev = dp.get(i - 1);
            // System.out.println(prev.toString());
            if (prev == null || prev.isEmpty()) {
                return new ArrayList();
            }
            for (Map.Entry<HashSet<Integer>, Integer> entry : prev.entrySet()) {
                HashSet<Integer> prevNums = entry.getKey();
                for (int j = 1; j <= 9; j++) {
                    if (!prevNums.contains(j) && entry.getValue() + j <= n) {
                        HashSet<Integer> newSet = new HashSet<>();
                        newSet.addAll(prevNums);
                        newSet.add(j);
                        HashMap<HashSet<Integer>, Integer> map = dp.getOrDefault(i, new HashMap<>());
                        map.put(newSet, entry.getValue() + j);
                        dp.put(i, map);
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<HashSet<Integer>, Integer> entry : dp.get(k).entrySet()) {
            if (entry.getValue() == n) {
                res.add(entry.getKey().stream().collect(Collectors.toList()));
            }
        }
        return res;
    }
}

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashMap<Integer, Set<List<Integer>>> dp = new HashMap<>();
        Set<List<Integer>> res = new HashSet<>();
        for (int curr : candidates) {
            // if (curr == 2) {
            //     System.out.println(dp.toString());
            // }
            int complement = target - curr;
            if (dp.containsKey(complement)) {
                for (List<Integer> group : dp.get(complement)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(group);
                    temp.add(curr);
                    res.add(temp);
                }
            }
            // Go through all the previous, and add the current to it
            List<Pair<Integer, Set<List<Integer>>>> newEntries = new ArrayList<>();
            for (Map.Entry<Integer, Set<List<Integer>>> entry : dp.entrySet()) {
                int newKey = entry.getKey() + curr;
                if (newKey > target) {
                    continue;
                }
                for (List<Integer> oldList : entry.getValue()) {
                    List<Integer> newList = new ArrayList<>();
                    newList.addAll(oldList);
                    newList.add(curr);
                    Set<List<Integer>> existing = dp.getOrDefault(newKey, new HashSet<>());
                    Set<List<Integer>> existingCopy = new HashSet<>();
                    existingCopy.add(newList);
                    newEntries.add(new Pair<>(newKey, existingCopy));
                }
            }
            for (Pair<Integer, Set<List<Integer>>> entry : newEntries) {
                Set<List<Integer>> existing = dp.getOrDefault(entry.getKey(), new HashSet<>());
                existing.addAll(entry.getValue());
                dp.put(entry.getKey(), existing);
            }
            // Finally add the single element list with just itself
            List<Integer> self = new ArrayList<>();
            self.add(curr);
            Set<List<Integer>> existing = dp.getOrDefault(curr, new HashSet<>());
            existing.add(self);
            dp.put(curr, existing);
            // If the candidate is equal to the target, add
            if (curr == target) {
                res.add(self);
            }
            // if (curr == 2) {
            //     System.out.println(dp.toString());
            // }
        }
        return res.stream().collect(Collectors.toList());
    }
}

class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[]{};
        }
        Arrays.sort(changed);
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int num : changed) {
            if (num % 2 == 0 && memo.getOrDefault(num / 2, 0) > 0) {
                res.add(num / 2);
                memo.put(num / 2, memo.get(num / 2) - 1);
                continue;
            }
            memo.put(num, memo.getOrDefault(num, 0) + 1);
        }
        if (res.size() != changed.length / 2) {
            return new int[]{};
        }
        int[] finalRes = new int[res.size()];
        for (int i = 0; i < finalRes.length; i++) {
            finalRes[i] = res.get(i);
        }
        return finalRes;
    }
}

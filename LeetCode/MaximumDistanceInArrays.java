class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int smallest = arrays.get(0).get(0);
        int biggest = arrays.get(0).get(arrays.get(0).size() - 1);
        int res = 0;
        boolean skip = true;
        for (List<Integer> arr : arrays) {
            if (skip) {
                skip = false;
                continue;
            }
            res = Math.max((int) Math.abs(biggest - arr.get(0)), res);
            res = Math.max((int) Math.abs(arr.get(arr.size() - 1) - smallest), res);
            smallest = Math.min(smallest, arr.get(0));
            biggest = Math.max(biggest, arr.get(arr.size() - 1));
        }
        return res;
    }
}

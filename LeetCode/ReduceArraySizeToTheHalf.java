class Solution {
    public int minSetSize(int[] arr) {
        // Seems like we can create a hashmap to count
        // Then sort and remove the amounts until we have less than or equal to half removed
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int a : arr) {
            counts.put(a, counts.getOrDefault(a, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(counts.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        int sizeTarget = arr.length / 2;
        int curr = arr.length;
        int i = 0;
        while (curr > sizeTarget) {
            curr -= list.get(i).getValue();
            i++;
        }
        return i;
    }
}

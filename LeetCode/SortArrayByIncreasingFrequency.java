class Solution {
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[250];
        for (int num : nums) {
            freq[num + 100]++;
        }
        Integer[] integerArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArray, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (freq[a + 100] == freq[b + 100]) {
                    return b - a;
                }
                return freq[a + 100] - freq[b + 100];
            }
        });
        return Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray();
    }
}

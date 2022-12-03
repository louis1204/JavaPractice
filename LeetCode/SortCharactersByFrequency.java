class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        Character[] arr = new Character[s.length()];
        int i = 0;
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            arr[i++] = c;
        }
        System.out.println(freq);
        Arrays.sort(arr, (a, b) -> {
            if (freq.get(b).equals(freq.get(a))) {
                // System.out.println("a: " + a + "b: " + b + " res: " + (((char)a) - ((char)b)));
                return (char)a - (char)b;
            }
            return freq.get(b) - freq.get(a);
        });
        StringBuilder sb = new StringBuilder();
        for (Character c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}

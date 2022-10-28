class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Hash the product of primes for each letter
        // Map each letter to a prime
        HashMap<HashMap<Character, Integer>, List<String>> setToList =
            new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            HashMap<Character, Integer> key = new HashMap<>();
            for (int j = 0; j < strs[i].length(); j++) {
                char ch = strs[i].charAt(j);
                if (key.containsKey(ch)) {
                    key.put(ch, key.get(ch) + 1);
                } else {
                    key.put(ch, 1);
                }
            }
            if (setToList.containsKey(key)) {
                List<String> newList = new ArrayList<>();
                List<String> val = setToList.get(key);
                newList.addAll(val);
                newList.add(strs[i]);
                setToList.put(key, newList);
            } else {
                setToList.put(key, Arrays.asList(strs[i]));
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : setToList.values()) {
            result.add(list);
        }
        return result;
    }
}

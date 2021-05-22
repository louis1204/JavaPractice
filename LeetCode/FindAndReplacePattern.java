class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String numRep = getNumRep(pattern);
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (numRep.equals(getNumRep(word))) {
                res.add(word);
            }
        }
        return res;
    }
    
    private String getNumRep(String pattern) {
        int index = 1;
        int[] arr = new int[26];
        String res = "";
        for (char c : pattern.toCharArray()) {
            int i = c - 'a';
            if (arr[i] == 0) {
                arr[i] = index++;
            }
            res += arr[i] + ",";
        }
        System.out.println(pattern);
        System.out.println(res);
        return res;
    }
}

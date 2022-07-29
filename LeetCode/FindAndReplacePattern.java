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

// Even faster
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        // Looks like we can serialize the pattern
        if (pattern.length() == 1) {
            return Arrays.asList(words);
        }
        int patSerial = getSerial(pattern);
        List<String> res = new ArrayList<>();
        // System.out.println(patSerial);
        for (String w : words) {
            // System.out.println(getSerial(w));
            if (getSerial(w) == patSerial) {
                res.add(w);
            }
        }
        return res;
    }
    
    private int getSerial(String s) {
        int[] alpha = new int[26];
        int count = 1;
        int serial = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (alpha[ch - 'a'] == 0) {
                alpha[ch - 'a'] = count++;
            }
            serial *= 10;
            serial += alpha[ch - 'a'];
        }
        return serial;
    }
}

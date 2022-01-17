class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, String> map = new HashMap<>();
        String[] ss = s.split(" ");
        String[] patternS = pattern.split("");
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(patternS.length, ss.length); i++) {
            if (map.containsKey(ss[i])) {
                if (!map.get(ss[i]).equals(patternS[i])) {
                    return false;
                }
            } else if (map.values().contains(patternS[i])) {
                return false;
            } else {
                map.put(ss[i], patternS[i]);
            }
            sb.append(map.get(ss[i]));
        }
        // System.out.println(sb.toString());
        // System.out.println(pattern);
        return sb.toString().equals(pattern) && sb.length() == ss.length;
    }
}

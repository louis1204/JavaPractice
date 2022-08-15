class Solution {
    private static final HashMap<Character, Integer> symbolToInt =
            new HashMap<>() {{
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }};
    
    public int romanToInt(String s) {
        int total = 0;
        for (int i = s.length() - 1; i >= 0;) {
            if (i ==  s.length() - 1) {
                total += symbolToInt.get(s.charAt(i));
                i--;
                continue;
            }
            int prev = symbolToInt.get(s.charAt(i + 1));
            int curr = symbolToInt.get(s.charAt(i));
            while (curr < prev) {
                total -= curr;
                i--;
                if (i < 0) break;
                curr = symbolToInt.get(s.charAt(i));
            }
            if (i >= 0) {
                total += symbolToInt.get(s.charAt(i));
                i--;
            }
        }
        return total;
    }
}

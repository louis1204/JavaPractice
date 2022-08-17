class Solution {
    String[] map = new String[] {
".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
    };
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> morse = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : word.toCharArray()) {
                sb.append(map[ch - 'a']);
            }
            morse.add(sb.toString());
        }
        return morse.size();
    }
}

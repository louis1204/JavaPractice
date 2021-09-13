class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] balloonCount = new int[26]; //b-a-l-o-n
        for (char ch : text.toCharArray()) {
            balloonCount[ch - 'a']++;
        }
        int min = balloonCount['b' - 'a'];
        min = Math.min(min, balloonCount['a' - 'a']);
        min = Math.min(min, balloonCount['l' - 'a'] / 2);
        min = Math.min(min, balloonCount['o' - 'a'] / 2);
        min = Math.min(min, balloonCount['n' - 'a']);
        return min;
    }
}

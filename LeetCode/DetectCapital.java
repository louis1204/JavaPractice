class Solution {
    public boolean detectCapitalUse(String word) {
        // Check if the to lower == word, then return true
        if (word.toLowerCase().equals(word)) {
            return true;
        }
        // Then check if to upper == word, then return true
        if (word.toUpperCase().equals(word)) {
            return true;
        }
        // Now all that's left is if there's any uppers that are not the first
        if (word.length() > 1 && word.substring(1).toLowerCase().equals(word.substring(1))) {
            return true;
        }
        return false;
    }
}

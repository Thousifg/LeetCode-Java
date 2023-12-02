class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Concatenate strings in word1 and word2
        String left = concatenateStrings(word1);
        String right = concatenateStrings(word2);

        // Use equals() method to compare strings
        return left.equals(right);
    }

    private String concatenateStrings(String[] words) {
        StringBuilder result = new StringBuilder();

        // Concatenate strings in the array
        for (String word : words) {
            result.append(word);
        }

        return result.toString();
    }
}
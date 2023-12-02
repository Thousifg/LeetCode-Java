class Solution {
    // Method to check if two arrays of strings represent equal words
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Concatenate strings in word1 and word2
        String left = concatenateStrings(word1);
        String right = concatenateStrings(word2);

        // Use equals() method to compare the concatenated strings
        return left.equals(right);
    }

    // Helper method to concatenate strings in an array
    private String concatenateStrings(String[] words) {
        // Use StringBuilder for efficient string concatenation
        StringBuilder result = new StringBuilder();

        // Concatenate strings in the array
        for (String word : words) {
            result.append(word);
        }

        // Convert StringBuilder to String and return
        return result.toString();
    }
}
class Solution {
    // Main method to calculate the total length of valid words
    public int countCharacters(String[] words, String chars) {
        // Calculate character counts for the given characters
        Map<Character, Integer> charCounts = calculateCharacterCounts(chars);

        // Initialize total length
        int totalLength = 0;

        // Iterate through each word and check if it's valid
        for (String word : words) {
            // Calculate character counts for the current word
            Map<Character, Integer> wordCounts = calculateCharacterCounts(word);

            // Check if the word is valid and update the total length
            if (isWordValid(charCounts, wordCounts)) {
                totalLength += word.length();
            }
        }

        // Return the total length of valid words
        return totalLength;
    }

    // Helper method to calculate character counts in a string
    private Map<Character, Integer> calculateCharacterCounts(String str) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : str.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts;
    }

    // Helper method to check if a word is valid based on character counts
    private boolean isWordValid(Map<Character, Integer> charCounts, Map<Character, Integer> wordCounts) {
        for (Map.Entry<Character, Integer> entry : wordCounts.entrySet()) {
            char c = entry.getKey();
            int wordCount = entry.getValue();

            // Check if the character count for the word is greater than or equal to the available count
            if (charCounts.getOrDefault(c, 0) < wordCount) {
                return false; // Word is not valid
            }
        }
        return true; // Word is valid
    }
}
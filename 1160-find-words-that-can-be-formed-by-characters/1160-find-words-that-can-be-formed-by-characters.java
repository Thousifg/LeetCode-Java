class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charCounts = calculateCharacterCounts(chars);

        int totalLength = 0;
        for (String word : words) {
            Map<Character, Integer> wordCounts = calculateCharacterCounts(word);

            if (isWordValid(charCounts, wordCounts)) {
                totalLength += word.length();
            }
        }

        return totalLength;
    }

    private Map<Character, Integer> calculateCharacterCounts(String str) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : str.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts;
    }

    private boolean isWordValid(Map<Character, Integer> charCounts, Map<Character, Integer> wordCounts) {
        for (Map.Entry<Character, Integer> entry : wordCounts.entrySet()) {
            char c = entry.getKey();
            int wordCount = entry.getValue();

            if (charCounts.getOrDefault(c, 0) < wordCount) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        StringBuilder lineBuilder = new StringBuilder();

        int lineStart = 0, lineLength = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() <= (maxWidth - lineLength)) {
                lineLength += words[i].length() + 1;
                continue;
            } else {
                int remainingSpaces = maxWidth - lineLength + 1;
                int wordsInLine = i - lineStart - 1;
                int spacesBetweenWords = 0;

                if (wordsInLine > 0) {
                    spacesBetweenWords = remainingSpaces / wordsInLine;
                    remainingSpaces = remainingSpaces % wordsInLine;
                }

                while (lineStart < i - 1) {
                    lineBuilder.append(words[lineStart++]).append(" ");
                    int spacesAdded = 0;
                    while (spacesAdded < spacesBetweenWords) {
                        lineBuilder.append(" ");
                        spacesAdded++;
                    }
                    if (remainingSpaces > 0) {
                        lineBuilder.append(" ");
                        remainingSpaces--;
                    }
                }
                lineBuilder.append(words[lineStart]);

                while (remainingSpaces > 0) {
                    lineBuilder.append(" ");
                    remainingSpaces--;
                }
                result.add(lineBuilder.toString());

                lineStart = i;
                lineLength = words[i].length() + 1;
                lineBuilder.setLength(0);
            }
        }

        lineBuilder.setLength(0);
        while (lineStart < words.length - 1) {
            lineBuilder.append(words[lineStart++]).append(" ");
        }
        lineBuilder.append(words[lineStart]);

        while (lineBuilder.length() < maxWidth) {
            lineBuilder.append(" ");
        }
        result.add(lineBuilder.toString());

        return result;
    }
}
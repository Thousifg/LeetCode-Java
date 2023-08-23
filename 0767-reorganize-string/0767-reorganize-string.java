class Solution {
    public class CharFrequency {
        char character;
        int frequency;

        CharFrequency(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
    }

    public String reorganizeString(String s) {
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            charFrequencyMap.put(s.charAt(i), charFrequencyMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<CharFrequency> maxHeap = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);

        for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
            maxHeap.add(new CharFrequency(entry.getKey(), entry.getValue()));
        }

        CharFrequency previous = new CharFrequency('#', -1);

        StringBuilder resultStringBuilder = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            CharFrequency current = maxHeap.poll();
            resultStringBuilder.append(current.character);
            current.frequency--;

            if (previous.frequency > 0) {
                maxHeap.add(previous);
            }

            previous = current;
        }

        if (resultStringBuilder.length() != s.length()) {
            return "";
        }
        
        return resultStringBuilder.toString();
    }
}
class Solution {
    public char findTheDifference(String s, String t) {
        // Initialize a map to store character counts for the target string 'targetStr'.
        Map<Character, Integer> count = new HashMap<>();

        // Count the occurrences of each character in the target string.
        for (char c : t.toCharArray()) {
            
        // Increment the count for character 'c' in the map or initialize it to 1 if it doesn't exist.
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // Iterate through each character in the source string 'sourceStr'.
         for (char c : s.toCharArray()) {
            
            // Decrease the count of character 'c' in the map.
            count.put(c, count.get(c) - 1);
    
            // If the count becomes zero, remove the character entry from the map.
            if (count.get(c) == 0) {
                count.remove(c);
            }
        }
        
        // Return the character that remains in the map (the extra character in 'sourceStr').
        return (char) count.keySet().toArray()[0];
    }
}
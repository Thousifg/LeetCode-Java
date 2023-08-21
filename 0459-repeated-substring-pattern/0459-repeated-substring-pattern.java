class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        
        // Check for possible repeating pattern lengths
        for (int patternLength = length / 2; patternLength >= 1; patternLength--) {
            if (length % patternLength == 0) {
                int repetitionCount = length / patternLength;
                String pattern = s.substring(0, patternLength);
                
                // Build a repeated string using the identified pattern
                StringBuilder repeatedString = new StringBuilder();
                for (int repetition = 0; repetition < repetitionCount; repetition++) {
                    repeatedString.append(pattern);
                }
                
                // Check if the repeated string matches the original input
                if (repeatedString.toString().equals(s)) {
                    return true; // Found a repeating pattern
                }
            }
        }
        
        return false; // No repeating pattern found
    }
}

class Solution {
    public int bestClosingTime(String customers) {
        
        // Tracks the maximum happy score encountered
        int maxHappyScore = 0;
        
        // Tracks the current score as we iterate through the customer history
        int currentScore = 0;  
        
        // Records the index of the right time for maximum happy score
        int rightTimeIndex = -1;
        
        for (int i = 0; i < customers.length(); ++i) {
            
            // Update the current score based on the presence of a happy customer ('Y') or not ('N')
            currentScore += (customers.charAt(i) == 'Y') ? 1 : -1;
            
            // If the current score is higher than the previous maximum score, update the max score and time index
            if (currentScore > maxHappyScore) {
                maxHappyScore = currentScore;
                rightTimeIndex = i;
            }
        }
        
        // Adding 1 to the index to convert from zero-based indexing to one-based indexing
        return rightTimeIndex + 1;
    }
}
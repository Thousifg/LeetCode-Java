class Solution {
    public int numberOfWays(String corridor) {
        // Step 1: Initialization
        int totalSeats = 0;                 // Total number of seats in the corridor
        int totalWays = 1;                  // Total number of ways to install dividers
        int currentSeatCount = 0;           // Current count of seats between dividers
        int currentPlantCount = 0;          // Current count of plants between dividers
        boolean isFirstDividerInstalled = false;  // Flag to check if the first divider is installed
        int mod = 1000000007;               // Constant for modulo operation

        // Step 2: Iterate through the Corridor
        for (int i = 0; i < corridor.length(); i++) {
            char ch = corridor.charAt(i);

            // If the current character is 'S', increment total seats and current seat count
            if (ch == 'S') {
                totalSeats++;
                currentSeatCount++;
            } 
            // If the current character is 'P' and no seats are encountered yet, increment current plant count
            else if (currentSeatCount == 0) {
                currentPlantCount++;
            }

            // Step 3: Install Dividers
            if (currentSeatCount == 2) {
                // If the first divider is installed, update total ways based on current plant count
                if (isFirstDividerInstalled) {
                    totalWays = (int) ((long) totalWays * (currentPlantCount + 1) % mod);
                }
                // Set the flag to indicate the first divider is installed
                isFirstDividerInstalled = true;
                // Reset current seat count and plant count for the next divider
                currentSeatCount = 0;
                currentPlantCount = 0;
            }
        }

        // Step 4: Check for Valid Configuration
        // If the total number of seats is even, return total ways modulo the constant
        return (totalSeats > 0 && totalSeats % 2 == 0) ? totalWays % mod : 0;
    }
}
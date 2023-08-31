class Solution {
    public int minTaps(int n, int[] ranges) {
        // Create an array to store the minimum steps needed to reach each position
        int[] minStepsToReach = new int[n + 1];
        
        // Initialize a value to represent infinity
        int infinity = (int) 1e9;

        // Initialize all positions with infinity, except the starting position which is 0 steps away
        Arrays.fill(minStepsToReach, infinity);
        minStepsToReach[0] = 0;

        // Iterate through each tap
        for (int i = 0; i < ranges.length; i++) {
            // Determine the left and right boundaries of the reachable area for the current tap
            int startRange = Math.max(0, i - ranges[i]);
            int endRange = Math.min(n, i + ranges[i]);

            // Iterate through the positions within the reachable area
            for (int j = startRange; j < endRange; j++) {
                // Update the minimum steps needed to reach the right boundary using the current tap
                minStepsToReach[endRange] = Math.min(minStepsToReach[endRange], minStepsToReach[j] + 1);
            }
        }

        // If the minimum steps needed to reach the last position is still infinity, it's not reachable
        // Otherwise, return the minimum steps needed to reach the last position
        return minStepsToReach[n] == infinity ? -1 : minStepsToReach[n];
    }
}
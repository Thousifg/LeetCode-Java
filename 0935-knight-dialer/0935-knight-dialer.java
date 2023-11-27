class Solution {
    // Function to count the number of distinct numbers a knight can dial in 'n' steps
    public int knightDialer(int n) {
        // Define the possible knight moves for each numeric cell
        int[][] moves = {
                {4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}
        };

        int mod = 1000000007;
        int[][] dp = new int[n][10];

        // Base case: There is one way to reach each cell in the first step
        Arrays.fill(dp[0], 1);

        // Fill the dp array using bottom-up dynamic programming approach
        for (int step = 1; step < n; step++) {
            for (int position = 0; position < 10; position++) {
                // For each numeric cell, calculate the number of ways to reach it in the current step
                for (int nextPosition : moves[position]) {
                    dp[step][position] = (dp[step][position] + dp[step - 1][nextPosition]) % mod;
                }
            }
        }

        // Sum up the counts for all numeric cells in the last step
        int total = Arrays.stream(dp[n - 1]).reduce(0, (acc, count) -> (acc + count) % mod);

        return total;
    }
}
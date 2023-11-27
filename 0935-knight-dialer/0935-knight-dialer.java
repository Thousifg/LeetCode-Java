class Solution {
    public int knightDialer(int n) {
        int[][] moves = {
                {4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}
        };

        int mod = 1000000007;
        int[][] dp = new int[n][10];

        Arrays.fill(dp[0], 1);

        for (int step = 1; step < n; step++) {
            for (int position = 0; position < 10; position++) {
                for (int nextPosition : moves[position]) {
                    dp[step][position] = (dp[step][position] + dp[step - 1][nextPosition]) % mod;
                }
            }
        }

        return Arrays.stream(dp[n - 1]).reduce(0, (total, count) -> (total + count) % mod);
    }
}
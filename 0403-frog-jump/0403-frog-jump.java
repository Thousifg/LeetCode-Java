class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        
        boolean[][] dp = new boolean[n][n + 1];
        
        dp[0][1] = true;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int jumpSize = stones[i] - stones[j];
                
                if (jumpSize <= j + 1) {
                    dp[i][jumpSize] = dp[j][jumpSize - 1] || dp[j][jumpSize] || dp[j][jumpSize + 1];
                    
                    if (i == n - 1 && dp[i][jumpSize]) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}
class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        
        // dp[i][j] represents whether a frog can jump to stone i with a jump size of j
        
        boolean[][] dp = new boolean[n][n + 1];
        
        // Base case: The frog can jump from stone 0 to stone 0 with jump size 1
        
        dp[0][1] = true;
        
        // Loop through each stone starting from the second stone
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                
                // Calculate the jump size from stone j to stone i
                
                int jumpSize = stones[i] - stones[j];
                
                // Check if the jump size is feasible, considering frog's capabilities
                
                if (jumpSize <= j + 1) {
                    
                    // The frog can jump to stone i with jump size jumpSize if it could 
                    // jump  stone j with jump sizes jumpSize - 1, jumpSize, or jumpSize + 1
                    
                    dp[i][jumpSize] = dp[j][jumpSize - 1] || dp[j][jumpSize] || dp[j][jumpSize + 1];
                    
                    // If we're at the last stone and the frog can jump to it, return true
                    
                    if (i == n - 1 && dp[i][jumpSize]) {
                        return true;
                    }
                }
            }
        }
        
        // The frog can't reach the last stone with any valid jump
        return false;
    }
}
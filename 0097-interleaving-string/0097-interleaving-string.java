class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        memoization = new int[s1.length() + 1][s2.length() + 1];
        return checkInterleave(0, 0, 0);
    }
    
    private String s1;
    private String s2;
    private String s3;
    private int[][] memoization;

    
    private boolean checkInterleave(int indexS1, int indexS2, int indexS3) {
        boolean isMatch = false;

        // Base case
        if (indexS3 == s3.length()) {
            return true;
        }

        // If the result is already memoized, return it
        if (memoization[indexS1][indexS2] != 0) {
            return memoization[indexS1][indexS2] == 1;
        }

        // If s1 matches, pick s1
        if (indexS1 < s1.length() && s1.charAt(indexS1) == s3.charAt(indexS3)) {
            isMatch = isMatch || checkInterleave(indexS1 + 1, indexS2, indexS3 + 1);
        }

        // If s2 matches, pick s2
        if (indexS2 < s2.length() && s2.charAt(indexS2) == s3.charAt(indexS3)) {
            isMatch = isMatch || checkInterleave(indexS1, indexS2 + 1, indexS3 + 1);
        }

        // Memorize the final answer
        memoization[indexS1][indexS2] = isMatch ? 1 : -1;

        return isMatch;
    }
}
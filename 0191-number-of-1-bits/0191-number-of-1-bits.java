public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        // Iterate through each bit until the integer becomes 0.
        while (n != 0) {
            // Flip the rightmost set bit to 0 in each iteration.
            n = n & (n - 1);
            count++;
        }

        return count;
        
    }
}
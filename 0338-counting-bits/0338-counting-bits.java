class Solution {
    public int[] countBits(int n) {
        // Create an integer array to store the results.
        int[] result = new int[n + 1];

        // Loop through numbers from 1 to n.
        for (int i = 1; i <= n; i++) {
            // The number of set bits (1s) in a binary representation of 'i'
            // can be calculated by adding the result of 'i >> 1' (right shift by 1)
            // with the least significant bit of 'i' (i & 1).
            // This utilizes bitwise operations to count set bits efficiently.
            result[i] = result[i >> 1] + (i & 1);
        }

        // Return the array containing the count of set bits for each number from 1 to n.
        return result;
    }
}
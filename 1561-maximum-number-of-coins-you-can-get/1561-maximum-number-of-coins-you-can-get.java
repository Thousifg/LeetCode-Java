class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        
        int i = 0, j = piles.length - 2;
        while (i < j) {
            i++; // Alice
            ans += piles[j]; // You
            j -= 2; // Bob
        }

        return ans;
    }
}
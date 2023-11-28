class Solution {
    public int numberOfWays(String corridor) {
        int totalSeats = 0;
        int totalWays = 1;
        int n = corridor.length();
        int mod = 1000000007;

        int currentSeatCount = 0;
        int currentPlantCount = 0;
        boolean isFirstDividerInstalled = false;

        for (int i = 0; i < n; i++) {
            char ch = corridor.charAt(i);

            if (ch == 'S') {
                totalSeats++;
                currentSeatCount++;
            } else if (currentSeatCount == 0) {
                currentPlantCount++;
            }

            if (currentSeatCount == 2) {
                if (isFirstDividerInstalled) {
                    totalWays = (int) ((long) totalWays * (currentPlantCount + 1) % mod);
                }
                isFirstDividerInstalled = true;
                currentSeatCount = 0;
                currentPlantCount = 0;
            }
        }

        return (totalSeats > 0 && totalSeats % 2 == 0) ? totalWays % mod : 0;
    }
}
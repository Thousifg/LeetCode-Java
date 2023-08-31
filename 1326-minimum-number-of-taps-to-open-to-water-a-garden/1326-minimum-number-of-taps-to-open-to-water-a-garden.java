class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] minStepsToReach = new int[n + 1];

        int infinity = (int) 1e9;

        Arrays.fill(minStepsToReach, infinity);
        minStepsToReach[0] = 0;

        for (int i = 0; i < ranges.length; i++) {
            int startRange = Math.max(0, i - ranges[i]);
            int endRange = Math.min(n, i + ranges[i]);

            for (int j = startRange; j < endRange; j++) {
                minStepsToReach[endRange] = Math.min(minStepsToReach[endRange], minStepsToReach[j] + 1);
            }
        }

        return minStepsToReach[n] == infinity ? -1 : minStepsToReach[n];
    }
}
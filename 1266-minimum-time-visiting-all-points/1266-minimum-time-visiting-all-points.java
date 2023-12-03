class Solution {
    // Calculate the time needed to move from one point to another
    private int calculateTime(int[] from, int[] to) {
        // Calculate the absolute difference in x and y coordinates
        int xDiff = Math.abs(from[0] - to[0]);
        int yDiff = Math.abs(from[1] - to[1]);

        // The maximum of xDiff and yDiff represents the time to move in the greater direction
        return Math.max(xDiff, yDiff);
    }

    // Calculate the minimum time to visit all points in the given array
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;

        // Iterate through the array starting from the second point
        for (int i = 1; i < points.length; i++) {
            // Calculate the time to move from the previous point to the current point
            totalTime += calculateTime(points[i - 1], points[i]);
        }

        // The accumulated totalTime represents the minimum time to visit all points
        return totalTime;
    }
}
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (matrix[i][j] == 1) ? (i == 0 ? 1 : matrix[i - 1][j] + 1) : 0;
            }
        }
        
        int maxArea = 0;
        
        for (int i = 0; i < rows; i++) {
            Arrays.sort(matrix[i]);
            maxArea = Math.max(maxArea, maxRectangleArea(matrix[i]));
        }   
        
        return maxArea;
    }
    
    private int maxRectangleArea(int heights[]) {
        int maxArea = 0;
        for (int pos = 0; pos < heights.length; pos++) {
            maxArea = Math.max(maxArea, heights[pos] * (heights.length - pos));
        }
        return maxArea;
    }
}